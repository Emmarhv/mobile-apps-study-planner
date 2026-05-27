package com.uc3m.android.helloworld.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uc3m.android.helloworld.data.SubjectUnit
import com.uc3m.android.helloworld.viewmodel.DataBaseViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.lazy.items



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitScreen(
    subjectId: String,
    navController: NavController,
    viewModel: DataBaseViewModel = viewModel()
) {
    val orange = Color(0xFFFF9966)
    val white = Color.White
    val lightGray = Color(0xFFF5F5F5)
    val darkGray = Color(0xFF333333)
    val cardBackground = Color(0xFFF8F8F8)

    // Function to get proper display name
    fun getDisplayName(id: String): String {
        return when (id) {
            "maths" -> "Mathematics"
            "science" -> "Science"
            "geo" -> "Geography"
            "history" -> "History"
            "bio" -> "Biology"
            "spanish" -> "Spanish"
            "english" -> "English"
            else -> id
        }
    }

    // Observe units from ViewModel
    val units by viewModel.units.observeAsState(emptyList())

    // Start real-time listening as soon as subjectId changes
    LaunchedEffect(subjectId) {
        viewModel.startListeningUnits(subjectId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = getDisplayName(subjectId),
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = white
                        )
                        Text(
                            text = "${units.size} Units Available",
                            fontSize = 14.sp,
                            color = white.copy(alpha = 0.8f)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = white
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = orange
                )
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = lightGray
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Units list
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(vertical = 16.dp)
                ) {
                    items(units) { unit ->
                        UnitCard(
                            unit = unit,
                            onClick = {
                                navController.navigate("questions_screen/${subjectId}/${unit.id}")
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun UnitCard(
    unit: SubjectUnit,
    onClick: () -> Unit
) {
    val orange = Color(0xFFFF9966)
    val white = Color.White
    val darkGray = Color(0xFF333333)
    val cardBackground = Color(0xFFF8F8F8)
    
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(scale)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                isPressed = true
                onClick()
            },
        colors = CardDefaults.cardColors(containerColor = white),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = unit.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = darkGray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "5 Questions", // TODO: Get actual question count
                    fontSize = 14.sp,
                    color = darkGray.copy(alpha = 0.6f)
                )
            }
            
            IconButton(
                onClick = onClick,
                modifier = Modifier
                    .size(40.dp)
                    .background(orange, RoundedCornerShape(20.dp))
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Start Unit",
                    tint = white
                )
            }
        }
    }
}
