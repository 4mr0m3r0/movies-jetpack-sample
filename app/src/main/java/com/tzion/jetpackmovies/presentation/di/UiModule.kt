package com.tzion.jetpackmovies.presentation.di

import com.tzion.jetpackmovies.common.NotificationChannelRegister
import com.tzion.jetpackmovies.domain.FindMoviesByName
import com.tzion.jetpackmovies.presentation.findmovies.SearchMovie
import com.tzion.jetpackmovies.presentation.findmovies.handler.FindIntentHandler
import com.tzion.jetpackmovies.presentation.findmovies.handler.SearchKeyboard
import com.tzion.jetpackmovies.presentation.findmovies.handler.SearchTopBar
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface UiModule {

    @Provides
    fun providesNotificationChannelRegister(): NotificationChannelRegister =
        NotificationChannelRegister()

    @Provides
    fun provideChainOfFindIntentHandler(useCase: FindMoviesByName): FindIntentHandler {
        val searchTopBar: FindIntentHandler = SearchTopBar(
            userIntent = SearchMovie(useCase = useCase)
        )
        return SearchKeyboard(
            successor = searchTopBar,
            userIntent = SearchMovie(useCase = useCase)
        )
    }
}
