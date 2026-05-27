package com.uc3m.android.helloworld.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.platform.LocalContext
import com.uc3m.android.helloworld.R
import com.uc3m.android.helloworld.auth.FirebaseAuthHelper
import android.widget.Toast
import kotlinx.coroutines.launch
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import com.uc3m.android.helloworld.utils.SoundManager

@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val authHelper = remember { FirebaseAuthHelper() }
    val soundManager = remember { SoundManager(context) }

    fun handleLogin() {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        scope.launch {
            isLoading = true
            try {
                val result = authHelper.signIn(email, password)
                result.fold(
                    onSuccess = {
                        val username = authHelper.getCurrentUsername()
                        soundManager.playNotificationSound()
                        Toast.makeText(context, "Welcome back, $username!", Toast.LENGTH_SHORT).show()
                        navController.navigate("home") {
                            popUpTo("login") { inclusive = true }
                        }
                    },
                    onFailure = { exception ->
                        Toast.makeText(context, "Login failed: ${exception.message}", Toast.LENGTH_SHORT).show()
                    }
                )
            } finally {
                isLoading = false
            }
        }
    }

    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFFF9966)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.31f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.TopCenter)
                )
            }
            
            Text(
                text = "Welcome Back Learner!",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(top = 30.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Email field
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedContainerColor = Color.White.copy(alpha = 0.1f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.1f)
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Password field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedContainerColor = Color.White.copy(alpha = 0.1f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.1f)
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Sign in button
            Button(
                onClick = { handleLogin() },
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(vertical = 20.dp),
                shape = RoundedCornerShape(10.dp),
                enabled = !isLoading
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Text(text = "Sign In", fontSize = 18.sp, color = Color.White)
                }
            }

            // Sign up link
            Row(
                modifier = Modifier
                    .clickable { navController.navigate("signup") }
                    .padding(vertical = 10.dp)
            ) {
                Text(text = "Not a member?")
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Sign up",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
        }
    }
}