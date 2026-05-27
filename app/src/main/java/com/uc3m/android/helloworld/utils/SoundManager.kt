package com.uc3m.android.helloworld.utils

import android.content.Context
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri

class SoundManager(private val context: Context) {
    private var mediaPlayer: MediaPlayer? = null

    fun playNotificationSound() {
        try {
            val notification: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(context, notification)
            mediaPlayer?.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}