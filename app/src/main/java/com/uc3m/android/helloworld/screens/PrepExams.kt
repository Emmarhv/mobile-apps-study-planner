package com.uc3m.android.helloworld.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrepExams(navController: NavController) {
    val titleColor = Color(0xFFFF9966)
    val white = Color.White
    val darkGray = Color(0xFF333333)
    val lightGray = Color(0xFFF5F5F5)
    val cardBackground = Color(0xFFF8F9FA)
    val accentColor = Color(0xFF4CAF50)
    
    // List of tips with emojis and split into title and description
    val tips = listOf(
        Triple("📅", "Plan your time", "Organize a study calendar"),
        Triple("📝", "Take good notes", "Keep your notes organized and clear"),
        Triple("☕", "Take proper breaks", "Don't forget to take breaks during study sessions"),
        Triple("💡", "Create summaries", "Summarize important information in small summaries or mind maps"),
        Triple("📖", "Study actively", "Practice exercises and ask yourself questions about the topics"),
        Triple("🎧", "Listen to soft music", "If it helps you focus, listen to instrumental music"),
        Triple("📚", "Review regularly", "Periodically review the topics to keep the knowledge fresh"),
        Triple("🤔", "Do mock exams", "Practice with past exams to familiarize yourself with it"),
        Triple("🥤", "Stay hydrated and eat well", "Drink water and eat healthy foods to maintain energy"),
        Triple("🛌", "Get enough sleep", "Make sure you get enough rest before the exam")
    )

    var currentTipIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Preparation of Exams",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = white
                    )
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
                    containerColor = titleColor
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(white)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Progress indicator and counter at the top
                LinearProgressIndicator(
                    progress = (currentTipIndex + 1).toFloat() / tips.size,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = titleColor,
                    trackColor = lightGray
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Tip ${currentTipIndex + 1} of ${tips.size}",
                    fontSize = 14.sp,
                    color = darkGray.copy(alpha = 0.7f)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Tip card with fade animation
                AnimatedContent(
                    targetState = currentTipIndex,
                    transitionSpec = {
                        fadeIn(animationSpec = tween(300)) togetherWith fadeOut(animationSpec = tween(300))
                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) { index ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(8.dp)
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(24.dp)
                            )
                            .clip(RoundedCornerShape(24.dp))
                            .background(cardBackground)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            // Emoji in a circle
                            Box(
                                modifier = Modifier
                                    .size(80.dp)
                                    .clip(RoundedCornerShape(40.dp))
                                    .background(accentColor.copy(alpha = 0.1f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = tips[index].first,
                                    fontSize = 40.sp
                                )
                            }
                            
                            Spacer(modifier = Modifier.height(32.dp))
                            
                            // Title in orange and larger
                            Text(
                                text = tips[index].second,
                                fontSize = 24.sp,
                                color = titleColor,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            
                            // Description
                            Text(
                                text = tips[index].third,
                                fontSize = 18.sp,
                                color = darkGray,
                                textAlign = TextAlign.Center,
                                lineHeight = 26.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Navigation buttons at the bottom
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Previous button
                    Button(
                        onClick = {
                            if (currentTipIndex > 0) {
                                currentTipIndex--
                            }
                        },
                        enabled = currentTipIndex > 0,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (currentTipIndex > 0) titleColor else lightGray
                        ),
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Previous",
                            tint = white
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Previous")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    // Next button
                    Button(
                        onClick = {
                            if (currentTipIndex < tips.size - 1) {
                                currentTipIndex++
                            }
                        },
                        enabled = currentTipIndex < tips.size - 1,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (currentTipIndex < tips.size - 1) titleColor else lightGray
                        ),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Next")
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Next",
                            tint = white
                        )
                    }
                }
            }
        }
    }
}


