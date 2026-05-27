package com.uc3m.android.helloworld.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uc3m.android.helloworld.data.Question
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import org.json.JSONObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.google.android.gms.maps.model.CameraPosition
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.uc3m.android.helloworld.R
import com.google.android.gms.maps.model.MapStyleOptions

@Composable
fun MapQuizScreen(
    question: Question,
    geojsonData: String,
    onAreaSelected: (String) -> Unit
) {
    val orange = Color(0xFFFF9966)
    val lightOrange = Color(0xFFFFE5D9)
    
    var selectedArea by remember { mutableStateOf<String?>(null) }
    var showConfirmDialog by remember { mutableStateOf(false) }
    var polygons by remember { mutableStateOf<List<PolygonData>>(emptyList()) }
    var answered by remember { mutableStateOf(false) }
    var isCorrect by remember { mutableStateOf<Boolean?>(null) }
    var correctArea by remember { mutableStateOf<String?>(null) }
    
    // Process GeoJSON data in a LaunchedEffect
    LaunchedEffect(geojsonData) {
        polygons = withContext(Dispatchers.Default) {
            try {
                val jsonObject = JSONObject(geojsonData)
                val features = jsonObject.getJSONArray("features")
                val result = mutableListOf<PolygonData>()
                
                for (i in 0 until features.length()) {
                    val feature = features.getJSONObject(i)
                    val properties = feature.getJSONObject("properties")
                    
                    // Determine what property we have to use according to the map that we need
                    val areaName = when (question.unitId) {
                        "u4geo" -> properties.getString("NAME_1")  // Comunidades autónomas
                        "u5geo" -> properties.getString("NAME_2")  // Provinces
                        "u6geo" -> properties.getString("name")    // Europe
                        else -> properties.getString("name")       // By default
                    }
                    
                    val geometry = feature.getJSONObject("geometry")
                    val geometryType = geometry.getString("type")
                    val coordinates = geometry.getJSONArray("coordinates")
                    
                    if (geometryType == "Polygon") {
                        val polygonPoints = mutableListOf<LatLng>()
                        val coords = coordinates.getJSONArray(0)
                        for (j in 0 until coords.length()) {
                            val point = coords.getJSONArray(j)
                            val lat = point.getDouble(1)
                            val lng = point.getDouble(0)
                            polygonPoints.add(LatLng(lat, lng))
                        }
                        result.add(PolygonData(areaName, polygonPoints))
                    } else if (geometryType == "MultiPolygon") {
                        // For MultiPolygon, process each exterior
                        for (k in 0 until coordinates.length()) {
                            val polygonPoints = mutableListOf<LatLng>()
                            val polygonCoords = coordinates.getJSONArray(k)
                            // First circle of coordinates (the exterior)
                            val coords = polygonCoords.getJSONArray(0)
                            for (j in 0 until coords.length()) {
                                val point = coords.getJSONArray(j)
                                val lat = point.getDouble(1)
                                val lng = point.getDouble(0)
                                polygonPoints.add(LatLng(lat, lng))
                            }
                            result.add(PolygonData(areaName, polygonPoints))
                        }
                    }
                }
                result
            } catch (e: Exception) {
                e.printStackTrace()
                emptyList()
            }
        }
        // Save the answer to colour it later
        correctArea = question.correctAnswer?.toString()
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Map
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            val context = LocalContext.current
            val mapProperties by remember {
                mutableStateOf(
                    MapProperties(
                        mapType = MapType.NORMAL,
                        isMyLocationEnabled = false,
                        mapStyleOptions = MapStyleOptions.loadRawResourceStyle(
                            context,
                            R.raw.map_style_no_labels
                        )
                    )
                )
            }
            
            val initialCameraPosition = when (question.unitId) {
                "u4geo", "u5geo" -> CameraPosition.fromLatLngZoom(LatLng(40.4637, -3.7492), 5.5f) // Spain
                "u6geo" -> CameraPosition.fromLatLngZoom(LatLng(54.5260, 15.2551), 3.5f) // Europe
                else -> CameraPosition.fromLatLngZoom(LatLng(40.4637, -3.7492), 5.5f) // By default Spain
            }

            val cameraPositionState = rememberCameraPositionState {
                position = initialCameraPosition
            }
            
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                properties = mapProperties,
                cameraPositionState = cameraPositionState,
                onMapClick = { /* Ignore direct map clicks */ }
            ) {
                polygons.forEach { polygonData ->
                    val isSelected = selectedArea == polygonData.areaName
                    val isCorrectArea = correctArea == polygonData.areaName
                    val fillColor = when {
                        answered && isSelected && isCorrect == true -> Color(0xFF4CAF50).copy(alpha = 0.5f) // Green - correct
                        answered && isSelected && isCorrect == false -> Color(0xFFF44336).copy(alpha = 0.5f) // Red - incorrect
                        answered && isCorrect == false && isCorrectArea -> Color(0xFF4CAF50).copy(alpha = 0.5f) // Green - correct if they commited a mistake
                        isSelected -> orange.copy(alpha = 0.5f)
                        else -> lightOrange.copy(alpha = 0.3f)
                    }
                    Polygon(
                        points = polygonData.points,
                        fillColor = fillColor,
                        strokeColor = orange,
                        strokeWidth = 2f,
                        clickable = !answered,
                        onClick = {
                            if (!answered) {
                                selectedArea = polygonData.areaName
                                showConfirmDialog = true
                            }
                            true
                        }
                    )
                }
            }
        }
        
        // Confirmation dialog
        if (showConfirmDialog && selectedArea != null) {
            AlertDialog(
                onDismissRequest = { showConfirmDialog = false },
                title = {
                    Text("Confirm Selection")
                },
                text = {
                    Text("Are you sure about your selection?")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            val userAnswer = selectedArea
                            val correct = userAnswer == question.correctAnswer?.toString()
                            isCorrect = correct
                            answered = true
                            showConfirmDialog = false
                            onAreaSelected(userAnswer!!)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = orange
                        )
                    ) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    OutlinedButton(
                        onClick = {
                            showConfirmDialog = false
                            selectedArea = null
                        }
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}

// Data class to hold polygon information
private data class PolygonData(
    val areaName: String,
    val points: List<LatLng>
)
