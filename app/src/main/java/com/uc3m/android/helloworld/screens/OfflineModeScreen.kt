package com.uc3m.android.helloworld.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Home

data class Question(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correctAnswer: Int
)

data class Subject(
    val name: String,
    val emoji: String,
    val questions: List<Question>
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfflineModeScreen(navController: NavController) {
    var selectedSubject by remember { mutableStateOf<Subject?>(null) }
    var selectedQuestion by remember { mutableStateOf<Question?>(null) }
    var selectedAnswer by remember { mutableStateOf<Int?>(null) }
    var showAnswer by remember { mutableStateOf(false) }

    val subjects = listOf(
        Subject(
            name = "Biology",
            emoji = "🧬",
            questions = listOf(
                Question(1, "What is the powerhouse of the cell?", listOf("nucleus", "mitochondria", "ribosome", "vacuole"), 1),
                Question(2, "Which system includes the heart?", listOf("nervous", "respiratory", "circulatory", "digestive"), 2),
                Question(3, "What is the basic unit of life?", listOf("tissue", "organ", "cell", "molecule"), 2),
                Question(4, "Which gas do plants absorb?", listOf("oxygen", "nitrogen", "carbon dioxide", "hydrogen"), 2),
                Question(5, "What is the largest organ in the human body?", listOf("heart", "brain", "skin", "liver"), 2),
                Question(6, "Which blood type is the universal donor?", listOf("A", "B", "AB", "O"), 3),
                Question(7, "What is the process of cell division called?", listOf("photosynthesis", "respiration", "mitosis", "digestion"), 2),
                Question(8, "Which organ produces insulin?", listOf("liver", "pancreas", "kidney", "stomach"), 1),
                Question(9, "What is the study of heredity called?", listOf("ecology", "genetics", "zoology", "botany"), 1),
                Question(10, "Which system includes the brain?", listOf("circulatory", "respiratory", "nervous", "digestive"), 2)
            )
        ),
        Subject(
            name = "English",
            emoji = "📖",
            questions = listOf(
                Question(1, "What is the past tense of 'go'?", listOf("gone", "went", "goed", "going"), 1),
                Question(2, "Which is a synonym for 'happy'?", listOf("sad", "joyful", "angry", "tired"), 1),
                Question(3, "What is the plural of 'child'?", listOf("childs", "children", "childes", "child"), 1),
                Question(4, "Which word is an adjective?", listOf("run", "quickly", "beautiful", "jump"), 2),
                Question(5, "What is the opposite of 'begin'?", listOf("start", "continue", "end", "pause"), 2),
                Question(6, "Which is a preposition?", listOf("run", "under", "jump", "eat"), 1),
                Question(7, "What is the present continuous of 'write'?", listOf("wrote", "writing", "written", "writed"), 1),
                Question(8, "Which is an irregular verb?", listOf("walk", "talk", "eat", "play"), 2),
                Question(9, "What is the comparative of 'good'?", listOf("gooder", "better", "best", "goodest"), 1),
                Question(10, "Which is a conjunction?", listOf("and", "run", "happy", "quickly"), 0)
            )
        ),
        Subject(
            name = "Geography",
            emoji = "🗺️",
            questions = listOf(
                Question(1, "What is the capital of France?", listOf("London", "Berlin", "Paris", "Madrid"), 2),
                Question(2, "Which is the largest ocean?", listOf("Atlantic", "Indian", "Pacific", "Arctic"), 2),
                Question(3, "Which country has the most population?", listOf("USA", "India", "China", "Russia"), 2),
                Question(4, "What is the longest river?", listOf("Amazon", "Nile", "Yangtze", "Mississippi"), 1),
                Question(5, "Which is the largest desert?", listOf("Sahara", "Gobi", "Arabian", "Antarctic"), 3),
                Question(6, "What is the capital of Japan?", listOf("Beijing", "Seoul", "Tokyo", "Bangkok"), 2),
                Question(7, "Which continent is the largest?", listOf("Africa", "Europe", "Asia", "America"), 2),
                Question(8, "What is the capital of Australia?", listOf("Sydney", "Melbourne", "Canberra", "Perth"), 2),
                Question(9, "Which is the smallest continent?", listOf("Europe", "Australia", "Antarctica", "South America"), 1),
                Question(10, "What is the capital of Brazil?", listOf("Rio de Janeiro", "São Paulo", "Brasilia", "Salvador"), 2)
            )
        ),
        Subject(
            name = "History",
            emoji = "📜",
            questions = listOf(
                Question(1, "Who was the first US President?", listOf("Thomas Jefferson", "George Washington", "John Adams", "Benjamin Franklin"), 1),
                Question(2, "When did World War II end?", listOf("1943", "1944", "1945", "1946"), 2),
                Question(3, "Who discovered America?", listOf("Vasco da Gama", "Christopher Columbus", "Ferdinand Magellan", "Marco Polo"), 1),
                Question(4, "Who painted the Mona Lisa?", listOf("Michelangelo", "Raphael", "Leonardo da Vinci", "Donatello"), 2),
                Question(5, "When was the French Revolution?", listOf("1776", "1789", "1799", "1804"), 1),
                Question(6, "Who was the first man on the moon?", listOf("Buzz Aldrin", "Neil Armstrong", "Yuri Gagarin", "Alan Shepard"), 1),
                Question(7, "When was the Berlin Wall built?", listOf("1955", "1961", "1968", "1972"), 1),
                Question(8, "Who wrote the Declaration of Independence?", listOf("George Washington", "Thomas Jefferson", "Benjamin Franklin", "John Adams"), 1),
                Question(9, "When did the Titanic sink?", listOf("1905", "1912", "1918", "1923"), 1),
                Question(10, "Who was the first female Prime Minister of UK?", listOf("Margaret Thatcher", "Theresa May", "Indira Gandhi", "Golda Meir"), 0)
            )
        ),
        Subject(
            name = "Maths",
            emoji = "📐",
            questions = listOf(
                Question(1, "What is 2 + 2?", listOf("3", "4", "5", "6"), 1),
                Question(2, "What is 5 × 3?", listOf("10", "15", "20", "25"), 1),
                Question(3, "What is 10 ÷ 2?", listOf("3", "4", "5", "6"), 2),
                Question(4, "What is 7 - 3?", listOf("2", "3", "4", "5"), 2),
                Question(5, "What is 3²?", listOf("6", "9", "12", "15"), 1),
                Question(6, "What is √16?", listOf("2", "3", "4", "5"), 2),
                Question(7, "What is 8 + 7?", listOf("13", "14", "15", "16"), 2),
                Question(8, "What is 6 × 4?", listOf("20", "22", "24", "26"), 2),
                Question(9, "What is 20 ÷ 5?", listOf("3", "4", "5", "6"), 1),
                Question(10, "What is 9 - 4?", listOf("3", "4", "5", "6"), 2)
            )
        ),
        Subject(
            name = "Science",
            emoji = "🔬",
            questions = listOf(
                Question(1, "What is the unit of force?", listOf("joule", "watt", "newton", "pascal"), 2),
                Question(2, "Which law states F=ma?", listOf("Newton's 1st", "Newton's 2nd", "Newton's 3rd", "Ohm's"), 1),
                Question(3, "What is the speed of light?", listOf("300,000 m/s", "300,000 km/s", "300,000 km/h", "300,000 m/h"), 1),
                Question(4, "Which is a vector quantity?", listOf("mass", "speed", "velocity", "temperature"), 2),
                Question(5, "What is the unit of power?", listOf("joule", "watt", "newton", "pascal"), 1),
                Question(6, "Which law states every action has an equal reaction?", listOf("Newton's 1st", "Newton's 2nd", "Newton's 3rd", "Ohm's"), 2),
                Question(7, "What is the unit of energy?", listOf("joule", "watt", "newton", "pascal"), 0),
                Question(8, "Which is a scalar quantity?", listOf("force", "velocity", "speed", "acceleration"), 2),
                Question(9, "What is the acceleration due to gravity?", listOf("9.8 m/s", "9.8 m/s²", "9.8 km/s", "9.8 km/s²"), 1),
                Question(10, "Which law relates current, voltage and resistance?", listOf("Newton's", "Ohm's", "Boyle's", "Charles'"), 1)
            )
        ),
        Subject(
            name = "Spanish",
            emoji = "🇪🇸",
            questions = listOf(
                Question(1, "¿Cuál es el artículo definido masculino singular?", listOf("la", "el", "los", "las"), 1),
                Question(2, "¿Qué tiempo verbal es 'había'?", listOf("presente", "pretérito perfecto", "pretérito imperfecto", "futuro"), 2),
                Question(3, "¿Cuál es el plural de 'lápiz'?", listOf("lápices", "lápizes", "lápizs", "lápiz"), 0),
                Question(4, "¿Qué palabra es un adjetivo?", listOf("correr", "rápido", "saltar", "comer"), 1),
                Question(5, "¿Cuál es el opuesto de 'comenzar'?", listOf("iniciar", "continuar", "terminar", "pausar"), 2),
                Question(6, "¿Cuál es una preposición?", listOf("correr", "debajo", "saltar", "comer"), 1),
                Question(7, "¿Qué tiempo es 'estoy escribiendo'?", listOf("pretérito", "presente continuo", "futuro", "condicional"), 1),
                Question(8, "¿Cuál es un verbo irregular?", listOf("caminar", "hablar", "ir", "jugar"), 2),
                Question(9, "¿Cuál es el comparativo de 'bueno'?", listOf("buenero", "mejor", "óptimo", "buenísimo"), 1),
                Question(10, "¿Cuál es una conjunción?", listOf("y", "correr", "feliz", "rápidamente"), 0)
            )
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = when {
                            selectedQuestion != null -> selectedSubject?.name ?: ""
                            selectedSubject != null -> selectedSubject?.name ?: ""
                            else -> "Offline Mode"
                        },
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFF9966),
                    titleContentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
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
                    contentColor = Color(0xFF000000),
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
                                        color = Color(0xFFFF9966),
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
                                        color = Color(0xFFFF9966),
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
                        onClick = { navController.navigate("home") },
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
                                        color = Color(0xFFFF9966),
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
                                    .size(96.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(96.dp)
                                        .background(Color(0xFFFF9966), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "💾",
                                        fontSize = 24.sp,
                                        color = Color.White,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        },
                        selected = true,
                        onClick = { /* Already on offline mode */ },
                        label = null,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Transparent,
                            unselectedIconColor = Color.Transparent,
                            indicatorColor = Color(0xFFF5F5F5)
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (selectedSubject == null) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(subjects) { subject ->
                        OfflineButton(
                            subjectName = "${subject.emoji} ${subject.name}",
                            onClick = { selectedSubject = subject }
                        )
                    }
                }
            } else if (selectedQuestion == null) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(selectedSubject!!.questions) { question ->
                        Card(
                            onClick = { selectedQuestion = question },
                            modifier = Modifier.fillMaxWidth(),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    text = question.question,
                                    style = MaterialTheme.typography.titleMedium,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                Text(
                                    text = "Click to answer",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            }
                        }
                    }
                }
            } else {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = selectedQuestion!!.question,
                            style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 24.dp)
                        )

                        selectedQuestion!!.options.forEachIndexed { index, option ->
                            OutlinedButton(
                                onClick = {
                                    selectedAnswer = index
                                    showAnswer = true
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    contentColor = if (showAnswer) {
                                        when {
                                            index == selectedQuestion!!.correctAnswer -> MaterialTheme.colorScheme.primary
                                            index == selectedAnswer -> MaterialTheme.colorScheme.error
                                            else -> MaterialTheme.colorScheme.onSurface
                                        }
                                    } else {
                                        MaterialTheme.colorScheme.onSurface
                                    }
                                )
                            ) {
                                Text(
                                    text = option,
                                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                                )
                            }
                        }

                        if (showAnswer) {
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = if (selectedAnswer == selectedQuestion!!.correctAnswer) {
                                    "Correct!"
                                } else {
                                    "Incorrect. The correct answer is: ${selectedQuestion!!.options[selectedQuestion!!.correctAnswer]}"
                                },
                                style = MaterialTheme.typography.titleMedium,
                                color = if (selectedAnswer == selectedQuestion!!.correctAnswer) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.error
                                }
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            selectedQuestion = null
                            selectedAnswer = null
                            showAnswer = false
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Back to Questions")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(
                        onClick = {
                            val currentIndex = selectedSubject!!.questions.indexOf(selectedQuestion)
                            val nextIndex = (currentIndex + 1) % selectedSubject!!.questions.size
                            selectedQuestion = selectedSubject!!.questions[nextIndex]
                            selectedAnswer = null
                            showAnswer = false
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Next Question")
                    }
                }
            }
        }
    }
}

@Composable
fun OfflineButton(subjectName: String, onClick: () -> Unit) {
    val naranjitafondo = Color(0xFFFF9966)

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(horizontal = 8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = naranjitafondo,
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
