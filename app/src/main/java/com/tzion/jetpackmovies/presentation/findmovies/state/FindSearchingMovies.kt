package com.tzion.jetpackmovies.presentation.findmovies.state

class FindSearchingMovies : FindState {
    override fun noResults(context: FindContext) {
        changeState(
            context = context,
            state = FindNotifyingNoResults.getInstance()
        )
        context.displayNoResultsScreen()
    }

    override fun successfulResults(context: FindContext) {
        changeState(
            context = context,
            state = FindListingMovies.getInstance()
        )
        context.displayMovies()
    }

    override fun searchFailed(context: FindContext) {
        changeState(
            context = context,
            state = FindNotifyingError.getInstance()
        )
        context.displayErrorScreen()
    }

    companion object {
        private var instance: FindState? = null

        fun getInstance(): FindState = instance ?: synchronized(this) {
            FindSearchingMovies().also { instance = it }
        }
    }
}
