package com.tzion.jetpackmovies.device.worker

import androidx.work.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class FavoriteMovieWorkRequest {

    fun makeFavoriteMovieWorkRequest(): PeriodicWorkRequest {
        val constraints = Constraints
            .Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        return PeriodicWorkRequestBuilder<FavoriteMovieWorker>(
            16, TimeUnit.MINUTES,1, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
    }

    private companion object {
        const val REPEAT_INTERVAL = 7L
        const val REPEAT_TEST_INTERVAL = 5L
        const val FLEX_INTERVAL = 4L
    }

}