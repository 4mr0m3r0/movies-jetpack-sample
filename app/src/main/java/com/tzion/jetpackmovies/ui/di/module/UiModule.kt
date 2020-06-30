package com.tzion.jetpackmovies.ui.di.module

import com.tzion.jetpackmovies.common.NotificationChannelRegister
import dagger.Module
import dagger.Provides

@Module
abstract class UiModule {

    companion object {
        @Provides
        fun providesNotificationChannelRegister(): NotificationChannelRegister =
            NotificationChannelRegister()
    }

}