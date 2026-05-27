package com.uc3m.android.helloworld.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultsScreen(
    navController: NavController,
    subjectName: String,
    score: Float,
    correctAnswers: Int,
    totalQuestions: Int
) {
    val orange = Color(0xFFFF9966)
    val white = Color(0xFFFFFFFF)
    val lightGray = Color(0xFFF5F5F5)
    val darkGray = Color(0xFF333333)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "$subjectName Results",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = white
                    )
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
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Score Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(containerColor = white),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Your Score",
                            fontSize = 20.sp,
                            color = darkGray,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "${score.toInt()}%",
                            fontSize = 48.sp,
                            color = orange,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "$correctAnswers out of $totalQuestions correct",
                            fontSize = 16.sp,
                            color = darkGray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Navigation buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    OutlinedButton(
                        onClick = { navController.navigateUp() },
                        modifier = Modifier.weight(1f),
                        shape = MaterialTheme.shapes.medium,
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = orange
                        )
                    ) {
                        Text("Try Again")
                    }
                    Button(
                        onClick = { navController.navigate("home") },
                        modifier = Modifier.weight(1f),
                        shape = MaterialTheme.shapes.medium,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = orange
                        )
                    ) {
                        Text("Back to Home")
                    }
                }
            }
        }
    }
} 