package com.tzion.jetpackmovies.device.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.tzion.jetpackmovies.common.NotificationChannelRegister
import com.tzion.jetpackmovies.device.notification.NotificationBuilder

class FavoriteMovieWorker(private val context: Context, workerParameters: WorkerParameters)
    : Worker(context, workerParameters) {

    override fun doWork(): Result {
        val notificationBuilder = NotificationBuilder(NotificationChannelRegister())
        notificationBuilder.showFavoriteMovieNotification(context)

        return Result.success()
    }

    companion object {
        const val WORK_NAME = "Favorite_Movie_Worker"
    }

}