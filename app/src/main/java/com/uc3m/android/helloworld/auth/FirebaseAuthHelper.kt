package com.uc3m.android.helloworld.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await

class FirebaseAuthHelper {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    suspend fun signUp(username: String, email: String, password: String): Result<FirebaseUser> {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            // Update the user's display name (username)
            result.user?.updateProfile(
                UserProfileChangeRequest.Builder()
                    .setDisplayName(username)
                    .build()
            )?.await()
            Result.success(result.user!!)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun signIn(email: String, password: String): Result<FirebaseUser> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            Result.success(result.user!!)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun signOut() {
        auth.signOut()
    }

    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }

    fun getCurrentUsername(): String? {
        return auth.currentUser?.displayName
    }

    fun getCurrentUserEmail(): String? {
        return auth.currentUser?.email
    }
} 