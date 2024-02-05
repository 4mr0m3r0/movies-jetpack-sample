package com.tzion.jetpackmovies.presentation.di

import com.tzion.jetpackmovies.common.NotificationChannelRegister
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object UiModule {

    @Provides
    fun providesNotificationChannelRegister(): NotificationChannelRegister =
        NotificationChannelRegister()
}
