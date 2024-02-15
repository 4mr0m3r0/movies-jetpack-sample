package com.tzion.jetpackmovies.device.worker

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import java.util.concurrent.TimeUnit

@ExperimentalAnimationApi
class FavoriteMovieWorkRequest {

    fun makeFavoriteMovieWorkRequest(): PeriodicWorkRequest {
        val constraints = Constraints
            .Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        return PeriodicWorkRequestBuilder<FavoriteMovieWorker>(
            REPEAT_INTERVAL, TimeUnit.MINUTES, FLEX_INTERVAL, TimeUnit.MINUTES
        )
            .setConstraints(constraints)
            .build()
    }

    private companion object {
        const val REPEAT_INTERVAL = 16L
        const val REPEAT_TEST_INTERVAL = 5L
        const val FLEX_INTERVAL = 1L
    }
}
