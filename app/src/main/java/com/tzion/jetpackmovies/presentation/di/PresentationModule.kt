package com.tzion.jetpackmovies.presentation.di

import com.tzion.jetpackmovies.domain.posters.FindMoviePosters
import com.tzion.jetpackmovies.presentation.search.SearchMovieIntent
import com.tzion.jetpackmovies.presentation.search.TapOnAMovieIntent
import com.tzion.jetpackmovies.presentation.search.intenthandler.FindIntentHandler
import com.tzion.jetpackmovies.presentation.search.intenthandler.SearchKeyboard
import com.tzion.jetpackmovies.presentation.search.intenthandler.SearchTopBar
import com.tzion.jetpackmovies.presentation.search.intenthandler.TapCard
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object PresentationModule {

    @Provides
    fun providesChainOfFindIntentHandler(findMoviePosters: FindMoviePosters): FindIntentHandler {
        val searchTopBar: FindIntentHandler = SearchTopBar(
            userIntent = SearchMovieIntent(findMoviePosters)
        )
        val searchKeyboard: FindIntentHandler = SearchKeyboard(
            successor = searchTopBar,
            userIntent = SearchMovieIntent(findMoviePosters)
        )
        return TapCard(
            successor = searchKeyboard,
            userIntent = TapOnAMovieIntent()
        )
    }
}