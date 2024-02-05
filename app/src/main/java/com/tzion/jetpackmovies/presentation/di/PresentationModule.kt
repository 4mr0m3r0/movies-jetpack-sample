package com.tzion.jetpackmovies.presentation.di

import com.tzion.jetpackmovies.presentation.findmovies.EnterFindSectionIntent
import com.tzion.jetpackmovies.presentation.findmovies.SearchMovieIntent
import com.tzion.jetpackmovies.presentation.findmovies.TapOnAMovieIntent
import com.tzion.jetpackmovies.presentation.findmovies.intenthandler.EnterScreen
import com.tzion.jetpackmovies.presentation.findmovies.intenthandler.FindIntentHandler
import com.tzion.jetpackmovies.presentation.findmovies.intenthandler.SearchKeyboard
import com.tzion.jetpackmovies.presentation.findmovies.intenthandler.SearchTopBar
import com.tzion.jetpackmovies.presentation.findmovies.intenthandler.TapCard
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object PresentationModule {

    @Provides
    fun providesChainOfFindIntentHandler(): FindIntentHandler {
        val enterScreen: FindIntentHandler = EnterScreen(
            userIntent = EnterFindSectionIntent()
        )
        val searchTopBar: FindIntentHandler = SearchTopBar(
            successor = enterScreen,
            userIntent = SearchMovieIntent()
        )
        val searchKeyboard: FindIntentHandler = SearchKeyboard(
            successor = searchTopBar,
            userIntent = SearchMovieIntent()
        )
        return TapCard(
            successor = searchKeyboard,
            userIntent = TapOnAMovieIntent()
        )
    }
}