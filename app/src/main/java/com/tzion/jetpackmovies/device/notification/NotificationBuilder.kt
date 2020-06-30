package com.tzion.jetpackmovies.device.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.common.NotificationChannelRegister
import com.tzion.jetpackmovies.ui.MainActivity
import javax.inject.Inject

class NotificationBuilder @Inject constructor(
    private val notificationRegister: NotificationChannelRegister) {

    fun showFavoriteMovieNotification(context: Context) {
        with(NotificationManagerCompat.from(context)) {
            notify(FAVORITE_MOVIE_NOTIFICATION_ID, makeFavoriteMovieNotificationBuilder(context).build())
        }
    }

    private fun makeFavoriteMovieNotificationBuilder(context: Context): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_local_movies)
            .setContentTitle(context.getString(R.string.favorites_movies))
            .setContentText(context.getString(R.string.review_your_favorite_list))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(makePendingIntent(context))
            .setAutoCancel(true)
    }

    private fun makePendingIntent(context: Context): PendingIntent? {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
        return PendingIntent.getActivity(
            context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    fun createFavoriteMovieNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationRegister.createNotificationChannel(
                channelId = CHANNEL_ID,
                channelName = CHANNEL_NAME,
                channelDescription = CHANNEL_DESCRIPTION,
                channelImportance = NotificationManager.IMPORTANCE_DEFAULT,
                context = context
            )
        }
    }

    private companion object {
        const val FAVORITE_MOVIE_NOTIFICATION_ID = 7000
        const val CHANNEL_ID = "favorite_movies_channel"
        const val CHANNEL_NAME = "Favorite Movies"
        const val CHANNEL_DESCRIPTION = "Movies you select as favorite"
    }

}