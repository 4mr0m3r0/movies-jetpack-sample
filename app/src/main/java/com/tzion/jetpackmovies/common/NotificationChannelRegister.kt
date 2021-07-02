package com.tzion.jetpackmovies.common

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi

class NotificationChannelRegister {

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel(
        channelId: String,
        channelName: String,
        channelDescription: String,
        channelImportance: Int,
        context: Context
    ) {
        registerTheChannelWithSystem(
            context,
            makeNotificationChannel(channelId, channelName, channelDescription, channelImportance)
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun makeNotificationChannel(
        channelId: String,
        channelName: String,
        channelDescription: String,
        channelImportance: Int
    ): NotificationChannel =
        NotificationChannel(channelId, channelName, channelImportance).apply {
            description = channelDescription
        }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun registerTheChannelWithSystem(context: Context, channel: NotificationChannel) {
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}
