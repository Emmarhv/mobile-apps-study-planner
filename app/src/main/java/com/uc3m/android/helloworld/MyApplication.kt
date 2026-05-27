package com.uc3m.android.helloworld

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        Log.d("MY_APP", "FirebaseApp.initializeApp() called")
    }
}
