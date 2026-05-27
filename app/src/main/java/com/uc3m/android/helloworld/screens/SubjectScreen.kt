package com.uc3m.android.helloworld.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uc3m.android.helloworld.viewmodel.DataBaseViewModel
import androidx.compose.runtime.livedata.observeAsState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectScreen(navController: NavController, viewModel: DataBaseViewModel = viewModel()) {
    // Define custom colors
    val orangeBackground = Color(0xFFFF9966)
    val whiteColor = Color.White
    val blackColor = Color.Black

    // Observe subjects from the ViewModel
    val subjects by viewModel.subjects.observeAsState(emptyList())


    // Scaffold = main layout with top and bottom bars
    Scaffold(
        topBar = {
            // Top bar with title
            TopAppBar(
                title = {
                    Text(
                        "Subjects",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = whiteColor
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = orangeBackground, // Orange background
                    titleContentColor = whiteColor // White title
                ),
                modifier = Modifier.fillMaxWidth() // To ensure it occupies the whole screen
            )
        },

        // Bottom Navigation Bar
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xFFF5F5F5))
            ) {
                NavigationBar(
                    containerColor = Color.Transparent,
                    contentColor = blackColor,
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                ) {
                    NavigationBarItem(
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(96.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(96.dp)
                                        .background(orangeBackground, CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "📚",
                                        fontSize = 24.sp,
                                        color = Color.White,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        },
                        selected = true,
                        onClick = { /* Already on subjects */ },
                        label = null,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Transparent,
                            unselectedIconColor = Color.Transparent,
                            indicatorColor = Color(0xFFF5F5F5)
                        )
                    )
                    NavigationBarItem(
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(48.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(Color(0xFFAAAAAA), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "📅",
                                        fontSize = 20.sp,
                                        color = orangeBackground,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        },
                        selected = false,
                        onClick = { navController?.navigate("study_plans") },
                        label = null,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Transparent,
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = Color.Transparent
                        )
                    )
                    NavigationBarItem(
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(48.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(Color(0xFFAAAAAA), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Home,
                                        contentDescription = "Home",
                                        tint = Color.White,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            }
                        },
                        selected = false,
                        onClick = { navController?.navigate("home") },
                        label = null,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Transparent,
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = Color.Transparent
                        )
                    )
                    NavigationBarItem(
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(48.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(Color(0xFFAAAAAA), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "📊",
                                        fontSize = 20.sp,
                                        color = orangeBackground,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        },
                        selected = false,
                        onClick = { navController?.navigate("educational_facts") },
                        label = null,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Transparent,
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = Color.Transparent
                        )
                    )
                    NavigationBarItem(
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(48.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(Color(0xFFAAAAAA), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "💾",
                                        fontSize = 20.sp,
                                        color = orangeBackground,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        },
                        selected = false,
                        onClick = { navController?.navigate("offline_mode") },
                        label = null,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Transparent,
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        // Main content
        // The content adjusts below the bar
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues), // to avoid overlay la topBar
            color = Color.White // white background for the content
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                // Lazy list of subjects with emojis and names
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(top = 16.dp, bottom = 32.dp)
                ) {
                    items(subjects.size) { index ->
                        val subject = subjects[index]
                        SubjectButton(subjectName = "${emojiForSubject(subject.name)} ${subject.name}") {
                            navController.navigate("units/${subject.id}")
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun SubjectButton(subjectName: String, onClick: () -> Unit) {
    val orangeBackground = Color(0xFFFF9966)


    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(horizontal = 8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = orangeBackground,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp),
    ) {
        Text(
            text = subjectName,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 1.sp
        )
    }
}

fun emojiForSubject(name: String): String {
    return when (name.lowercase()) {
        "maths" -> "📐"
        "geography" -> "🗺️"
        "history" -> "📜"
        "english" -> "📖"
        "spanish" -> "🇪🇸"
        "biology" -> "🧬"
        "science" -> "🔬"

        else -> "📚"
    }
}