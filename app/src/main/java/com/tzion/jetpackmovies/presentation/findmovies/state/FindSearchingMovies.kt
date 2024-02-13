package com.tzion.jetpackmovies.presentation.findmovies.state

import com.tzion.jetpackmovies.presentation.model.ViewPoster

class FindSearchingMovies : FindState {
    override fun noResults(context: FindStateContext) {
        changeState(
            context = context,
            state = FindNotifyingNoResults.getInstance()
        )
        context.displayNoResultsScreen()
    }

    override fun successfulResults(context: FindStateContext, posters: List<ViewPoster>) {
        changeState(
            context = context,
            state = FindListingMovies.getInstance()
        )
        context.displayMovies(posters)
    }

    override fun searchFailed(context: FindStateContext, error: String?) {
        changeState(
            context = context,
            state = FindNotifyingError.getInstance()
        )
        context.displayErrorScreen(error)
    }

    companion object {
        private var instance: FindState? = null

        fun getInstance(): FindState = instance ?: synchronized(this) {
            FindSearchingMovies().also { instance = it }
        }
    }
}
