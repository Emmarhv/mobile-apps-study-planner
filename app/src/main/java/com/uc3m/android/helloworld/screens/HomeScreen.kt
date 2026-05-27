package com.uc3m.android.helloworld.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uc3m.android.helloworld.auth.FirebaseAuthHelper
import androidx.compose.ui.text.font.FontStyle
import com.uc3m.android.helloworld.utils.SoundManager
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uc3m.android.helloworld.viewmodel.DataBaseViewModel
import androidx.compose.runtime.livedata.observeAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: DataBaseViewModel = viewModel()
) { 
    val whiteColor = Color(0xFFFFFFFF)
    val blackColor = Color(0xFF000000)
    val naranjitafondo = Color(0xFFFF9966)
    val backgroundColor = Color(0xFFFFE5D9)

    var showMenu by remember { mutableStateOf(false) }
    var username by remember { mutableStateOf("") }
    val authHelper = remember { FirebaseAuthHelper() }
    val scope = rememberCoroutineScope()

    val context = LocalContext.current
    val soundManager = remember { SoundManager(context) }

    // Fetch username when the screen is created
    LaunchedEffect(Unit) {
        username = authHelper.getCurrentUsername() ?: "User"
    }

    // Observe subjects
    val subjects by viewModel.subjects.observeAsState(emptyList())

    // Observe completed tests
    val completedTests by viewModel.completedTests.observeAsState(emptySet())

    // State for daily tests and their completion status
    var dailyTests by remember { mutableStateOf(emptyList<Triple<String, String, Boolean>>()) }

    // Generate daily tests only once when subjects are loaded
    LaunchedEffect(subjects) {
        if (subjects.isNotEmpty() && dailyTests.isEmpty()) {
            // Get 3 random subjects
            val selectedSubjects = subjects.shuffled().take(3)
            dailyTests = selectedSubjects.mapNotNull { subject ->
                subject.id?.let { id ->
                    Triple(
                        subject.name,
                        id,
                        completedTests.contains(id)
                    )
                }
            }
        }
    }

    // Update completion status when completed tests change
    LaunchedEffect(completedTests) {
        if (dailyTests.isNotEmpty()) {
            dailyTests = dailyTests.map { (name, id, _) ->
                Triple(name, id, completedTests.contains(id))
            }
        }
    }

    // Function to mark a test as completed
    fun markTestAsCompleted(subjectId: String) {
        dailyTests = dailyTests.map { (name, id, completed) ->
            if (id == subjectId) Triple(name, id, true) else Triple(name, id, completed)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Welcome back,",
                            fontSize = 16.sp,
                            color = whiteColor
                        )
                        Text(
                            text = username,
                            fontSize = 25.sp,
                            color = whiteColor,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontStyle = FontStyle.Italic
                            )
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = naranjitafondo,
                    titleContentColor = blackColor
                ),
                actions = {
                    Box {
                        IconButton(onClick = { showMenu = true }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "More options",
                                tint = blackColor
                            )
                        }
                        DropdownMenu(
                            expanded = showMenu,
                            onDismissRequest = { showMenu = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Profile Settings") },
                                onClick = {
                                    showMenu = false
                                    navController.navigate("profile_settings")
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Logout") },
                                onClick = {
                                    showMenu = false
                                    authHelper.signOut()
                                    navController.navigate("login") {
                                        popUpTo("home") { inclusive = true }
                                    }
                                }
                            )
                        }
                    }
                }
            )
        },
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
                                        text = "📚",
                                        fontSize = 20.sp,
                                        color = naranjitafondo,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        },
                        selected = false,
                        onClick = { navController.navigate("subjects") },
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
                                        text = "📅",
                                        fontSize = 20.sp,
                                        color = naranjitafondo,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        },
                        selected = false,
                        onClick = { navController.navigate("study_plans") },
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
                                    .size(80.dp)
                                    .background(naranjitafondo, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Home,
                                    contentDescription = "Home",
                                    tint = whiteColor,
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                        },
                        selected = true,
                        onClick = { /* Already on home */ },
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
                                        text = "📊",
                                        fontSize = 20.sp,
                                        color = naranjitafondo,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        },
                        selected = false,
                        onClick = { navController.navigate("educational_facts") },
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
                                        color = naranjitafondo,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        },
                        selected = false,
                        onClick = { navController.navigate("offline_mode") },
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(whiteColor)
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                // Welcome Message
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Welcome to",
                        fontSize = 24.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "StudyStorm!",
                        fontSize = 44.sp,
                        color = naranjitafondo,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = (-1).sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp)
                    )
                    // Decorative line
                    Box(
                        modifier = Modifier
                            .width(60.dp)
                            .height(4.dp)
                            .padding(top = 16.dp)
                            .background(
                                color = naranjitafondo,
                                shape = RoundedCornerShape(2.dp)
                            )
                    )
                }

                Spacer(modifier = Modifier.weight(0.5f))

                // Motivational Quote
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "\"The future belongs to those",
                        fontSize = 20.sp,
                        color = Color(0xFF666666),
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        lineHeight = 26.sp
                    )
                    Text(
                        text = "who believe in the beauty",
                        fontSize = 20.sp,
                        color = Color(0xFF666666),
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        lineHeight = 26.sp
                    )
                    Text(
                        text = "of their dreams\"",
                        fontSize = 20.sp,
                        color = Color(0xFF666666),
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        lineHeight = 26.sp,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                    Text(
                        text = "— Eleanor Roosevelt",
                        fontSize = 16.sp,
                        color = naranjitafondo,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic
                    )
                }

                Spacer(modifier = Modifier.weight(0.5f))

                // Today's Menu Section with distinct styling
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFFF5EC)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 0.dp
                    ),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Today's Menu",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = naranjitafondo
                            )
                            Text(
                                text = "🍽️",
                                fontSize = 20.sp
                            )
                        }
                        
                        Spacer(modifier = Modifier.height(12.dp))

                        // Practice Test Links
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { navController.navigate("questions_screen/maths/u1maths") },
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 2.dp
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(
                                            color = Color(0xFF4CAF50).copy(alpha = 0.1f),
                                            shape = CircleShape
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "🧮",
                                        fontSize = 24.sp
                                    )
                                }
                                
                                Spacer(modifier = Modifier.width(12.dp))
                                
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = "Maths Quiz",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF333333)
                                    )
                                    Text(
                                        text = "Test your knowledge with a quick quiz",
                                        fontSize = 14.sp,
                                        color = Color(0xFF666666)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { navController.navigate("questions_screen/science/u1science") },
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 2.dp
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(
                                            color = Color(0xFF4CAF50).copy(alpha = 0.1f),
                                            shape = CircleShape
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "🔬",
                                        fontSize = 24.sp
                                    )
                                }
                                
                                Spacer(modifier = Modifier.width(12.dp))
                                
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = "Science Quiz",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF333333)
                                    )
                                    Text(
                                        text = "Test your knowledge with a quick quiz",
                                        fontSize = 14.sp,
                                        color = Color(0xFF666666)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { navController.navigate("questions_screen/geo/u1geo") },
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 2.dp
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(
                                            color = Color(0xFF4CAF50).copy(alpha = 0.1f),
                                            shape = CircleShape
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "🌍",
                                        fontSize = 24.sp
                                    )
                                }
                                
                                Spacer(modifier = Modifier.width(12.dp))
                                
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = "Geography Quiz",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF333333)
                                    )
                                    Text(
                                        text = "Test your knowledge with a quick quiz",
                                        fontSize = 14.sp,
                                        color = Color(0xFF666666)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PracticeTestLink(
    emoji: String,
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    completed: Boolean = false
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = if (completed) Color(0xFFE8F5E9) else Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Emoji Circle
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = if (completed) Color(0xFF4CAF50).copy(alpha = 0.2f) else Color(0xFF4CAF50).copy(alpha = 0.1f),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (completed) "✅" else emoji,
                    fontSize = 24.sp
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Title and Subtitle
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (completed) Color(0xFF2E7D32) else Color(0xFF333333)
                )
                Text(
                    text = subtitle,
                    fontSize = 14.sp,
                    color = if (completed) Color(0xFF2E7D32) else Color(0xFF666666)
                )
            }
        }
    }
}

private fun getSubjectEmoji(subjectName: String): String {
    return when (subjectName.lowercase()) {
        "maths" -> "🧮"
        "science" -> "🔬"
        "geography" -> "🌍"
        "history" -> "📜"
        "biology" -> "🧬"
        "spanish" -> "📖"
        "english" -> "🗣️"
        else -> "📚"
    }
}

