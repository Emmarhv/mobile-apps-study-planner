package com.uc3m.android.helloworld.screens

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.platform.LocalContext
import com.uc3m.android.helloworld.auth.FirebaseAuthHelper
import android.widget.Toast
import kotlinx.coroutines.launch
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun SignUpScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val authHelper = remember { FirebaseAuthHelper() }

    fun handleSignUp() {
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return
        }

        if (password.length < 6) {
            Toast.makeText(context, "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show()
            return
        }

        scope.launch {
            isLoading = true
            try {
                val result = authHelper.signUp(username, email, password)
                result.fold(
                    onSuccess = {
                        Toast.makeText(context, "Account created successfully!", Toast.LENGTH_SHORT).show()
                        navController.navigate("login") {
                            popUpTo("signup") { inclusive = true }
                        }
                    },
                    onFailure = { exception ->
                        Toast.makeText(context, "Sign up failed: ${exception.message}", Toast.LENGTH_SHORT).show()
                    }
                )
            } finally {
                isLoading = false
            }
        }
    }

    Surface(modifier = Modifier.fillMaxSize().background(Color(0xFFFF9966)), color = Color(0xFFFF9966)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "STUDYSTORM",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(top = 30.dp)
            )
            Text(
                text = "Create Account",
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFfc4b08),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(top = 30.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))

            //Username field
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username*") },
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

            //email field
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email*") },
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

            //password field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password*") },
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
            Spacer(modifier = Modifier.height(10.dp))
            
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password*") },
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
            Button(
                onClick = { handleSignUp() },
                modifier = Modifier.fillMaxWidth(0.5f),
                shape = RoundedCornerShape(10.dp),
                enabled = !isLoading
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Text(text = "Sign Up")
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.clickable { navController.navigate("login") }) {
                Text(text = "Already a member?")
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Sign In", color = Color.White)
            }
        }
    }
}