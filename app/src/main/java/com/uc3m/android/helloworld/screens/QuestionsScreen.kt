package com.uc3m.android.helloworld.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uc3m.android.helloworld.data.Question
import com.uc3m.android.helloworld.viewmodel.DataBaseViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uc3m.android.helloworld.data.QuestionType
import androidx.compose.foundation.clickable
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.platform.LocalContext
import android.content.Context
import java.io.IOException



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionsScreen(
    unitId: String,
    subjectId: String,
    navController: NavController,
    viewModel: DataBaseViewModel = viewModel()
) {
    val orange = Color(0xFFFF9966)
    val white = Color.White
    val lightOrange = Color(0xFFFFE5D9)
    val green = Color(0xFF4CAF50)
    val red = Color(0xFFF44336)

    // observe only the 5 random questions we load once
    val questions by viewModel.randomQuestions.observeAsState(emptyList())
    val currentQuestionIndex = remember { mutableStateOf(0) }
    val answeredQuestions = remember { mutableStateMapOf<String, String>() }
    val hasAnsweredAnyQuestion = remember { derivedStateOf { answeredQuestions.isNotEmpty() } }

    LaunchedEffect(subjectId, unitId) {
        viewModel.loadRandomQuestions(subjectId, unitId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Practice Questions",
                        fontSize = 28.sp,
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
            color = lightOrange
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Show all questions up to the current one
                items(questions.take(currentQuestionIndex.value + 1)) { question ->
                    QuestionCard(
                        question = question,
                        questionNumber = questions.indexOf(question) + 1,
                        answeredQuestions = answeredQuestions,
                        onAnswerSelected = { questionId, answer ->
                            answeredQuestions[questionId] = answer
                            // Move to next question after a short delay
                            if (currentQuestionIndex.value < questions.size - 1) {
                                currentQuestionIndex.value++
                            }
                        }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    if (currentQuestionIndex.value == questions.size - 1 && hasAnsweredAnyQuestion.value) {
                        Button(
                            onClick = {
                                val score = calculateScore(questions, answeredQuestions)
                                val correctAnswers = answeredQuestions.count { (questionId, answer) ->
                                    val question = questions.find { it.id == questionId }
                                    when (question?.type) {
                                        QuestionType.SHORT_ANSWER, QuestionType.TRUE_FALSE -> 
                                            answer.toString().toLowerCase() == question.correctAnswer?.toString()?.toLowerCase()
                                        else -> answer == question?.correctAnswer
                                    }
                                }
                                // Mark the test as completed in the HomeScreen
                                viewModel.markTestAsCompleted(subjectId)
                                navController.navigate("results/${score.toInt()}/$subjectId/$correctAnswers/${questions.size}")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = orange
                            )
                        ) {
                            Text(
                                "View Results",
                                fontSize = 18.sp,
                                color = white
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun calculateScore(questions: List<Question>, answeredQuestions: Map<String, String>): Float {
    var correctAnswers = 0
    questions.forEach { question ->
        val userAnswer = answeredQuestions[question.id]
        val isCorrect = when (question.type) {
            QuestionType.SHORT_ANSWER, QuestionType.TRUE_FALSE -> {
                if (userAnswer == null || question.correctAnswer == null) false
                else userAnswer.toString().toLowerCase() == question.correctAnswer.toString().toLowerCase()
            }
            else -> userAnswer == question.correctAnswer
        }
        if (isCorrect) {
            correctAnswers++
        }
    }
    return (correctAnswers.toFloat() / questions.size) * 100
}

@Composable
fun QuestionCard(
    question: Question,
    questionNumber: Int,
    answeredQuestions: MutableMap<String, String>,
    onAnswerSelected: (String, String) -> Unit
) {
    val userAnswer = question.id?.let { answeredQuestions[it] }
    val isAnswered = userAnswer != null
    val isCorrect = when (question.type) {
        QuestionType.SHORT_ANSWER, QuestionType.TRUE_FALSE -> {
            if (userAnswer == null || question.correctAnswer == null) false
            else userAnswer.toString().toLowerCase() == question.correctAnswer.toString().toLowerCase()
        }
        else -> userAnswer == question.correctAnswer
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF5EC)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Question $questionNumber",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = question.questionText,
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            when (question.type) {
                QuestionType.MULTIPLE_CHOICE -> MultipleChoiceQuestion(
                    question = question,
                    userAnswer = userAnswer,
                    isAnswered = isAnswered,
                    onAnswerSelected = { answer ->
                        question.id?.let { onAnswerSelected(it, answer) }
                    }
                )
                QuestionType.TRUE_FALSE -> TrueFalseQuestion(
                    question = question,
                    userAnswer = userAnswer,
                    isAnswered = isAnswered,
                    onAnswerSelected = { answer ->
                        question.id?.let { onAnswerSelected(it, answer) }
                    }
                )
                QuestionType.SHORT_ANSWER -> ShortAnswerQuestion(
                    question = question,
                    userAnswer = userAnswer,
                    isAnswered = isAnswered,
                    onAnswerSelected = { answer ->
                        question.id?.let { onAnswerSelected(it, answer) }
                    }
                )

                QuestionType.MAP -> MapQuestion(
                    question = question,
                    userAnswer = userAnswer,
                    isAnswered = isAnswered,
                    onAnswerSelected = { answer ->
                        question.id?.let { onAnswerSelected(it, answer) }
                    }
                )
            }

            // Show feedback after answering
            if (isAnswered) {
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isCorrect) Color(0xFFE8F5E9) else Color(0xFFFFEBEE)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = if (isCorrect) "Correct!" else "Incorrect",
                            color = if (isCorrect) Color(0xFF2E7D32) else Color(0xFFC62828),
                            fontWeight = FontWeight.Bold
                        )
                        if (!isCorrect) {
                            Spacer(modifier = Modifier.height(8.dp))
                            val isMapUnit = question.unitId == "u4geo" || question.unitId == "u5geo" || question.unitId == "u6geo"
                            if (isMapUnit) {
                                Text(
                                    text = "You selected: ${userAnswer}",
                                    color = Color(0xFFC62828)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Correct answer: ${question.correctAnswer}",
                                    color = Color(0xFF2E7D32)
                                )
                            } else {
                                Text(
                                    text = "Correct answer: ${question.correctAnswer}",
                                    color = Color(0xFF2E7D32)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MultipleChoiceQuestion(
    question: Question,
    userAnswer: String?,
    isAnswered: Boolean,
    onAnswerSelected: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        question.options?.forEach { option ->
            val isSelected = userAnswer == option
            val isCorrect = option == question.correctAnswer && isAnswered

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (!isAnswered) {
                            onAnswerSelected(option)
                        }
                    },
                colors = CardDefaults.cardColors(
                    containerColor = when {
                        isCorrect -> Color(0xFFE8F5E9)
                        isSelected -> Color(0xFFFFEBEE)
                        else -> Color.White
                    }
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = option,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    color = when {
                        isCorrect -> Color(0xFF2E7D32)
                        isSelected -> Color(0xFFC62828)
                        else -> Color.Black
                    }
                )
            }
        }
    }
}

@Composable
fun TrueFalseQuestion(
    question: Question,
    userAnswer: String?,
    isAnswered: Boolean,
    onAnswerSelected: (String) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        listOf("True", "False").forEach { option ->
            val isSelected = userAnswer?.toString()?.toLowerCase() == option.toLowerCase()
            val isCorrect = option.toLowerCase() == question.correctAnswer?.toString()?.toLowerCase() && isAnswered

            Card(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        if (!isAnswered) {
                            onAnswerSelected(option)
                        }
                    },
                colors = CardDefaults.cardColors(
                    containerColor = when {
                        isCorrect -> Color(0xFFE8F5E9)
                        isSelected -> Color(0xFFFFEBEE)
                        else -> Color.White
                    }
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = option,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                    color = when {
                        isCorrect -> Color(0xFF2E7D32)
                        isSelected -> Color(0xFFC62828)
                        else -> Color.Black
                    }
                )
            }
        }
    }
}

@Composable
fun ShortAnswerQuestion(
    question: Question,
    userAnswer: String?,
    isAnswered: Boolean,
    onAnswerSelected: (String) -> Unit
) {
    var text by remember { mutableStateOf(userAnswer ?: "") }
    var isSubmitting by remember { mutableStateOf(false) }

    Column {
        BasicTextField(
            value = text,
            onValueChange = {
                if (!isAnswered && !isSubmitting) {
                    text = it
                }
            },
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        if (!isAnswered && text.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    isSubmitting = true
                    onAnswerSelected(text)
                },
                modifier = Modifier.align(Alignment.End),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF9966)
                )
            ) {
                Text("Submit Answer")
            }
        }
    }
}

@Composable
fun MapQuestion(
    question: Question,
    userAnswer: String?,
    isAnswered: Boolean,
    onAnswerSelected: (String) -> Unit
) {
    val geojsonData = loadGeoJsonData(question.unitId ?: "")
    
    Column {
        MapQuizScreen(
            question = question,
            geojsonData = geojsonData,
            onAreaSelected = { areaName ->
                if (!isAnswered) {
                    onAnswerSelected(areaName)
                }
            }
        )
    }
}

@Composable
fun loadGeoJsonData(unitId: String): String {
    val context = LocalContext.current
    val fileName = when (unitId) {
        "u4geo" -> "spain_communities.geojson"    // Spanish Communities
        "u5geo" -> "spain_provincias.geojson"     // Spanish Provinces
        "u6geo" -> "europe.geojson"               // European Countries
        else -> "europe.geojson"                  // Default map
    }
    return readGeoJsonFromAssets(context, fileName) ?: ""
}

fun readGeoJsonFromAssets(context: Context, fileName: String): String? {
    return try {
        context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (e: IOException) {
        e.printStackTrace()
        null
    }
}

