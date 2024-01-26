package com.tzion.jetpackmovies.presentation.findmovies.state

class FindListingMovies : FindState {
    override fun pressSearchButton(context: FindContext) {
        changeState(
            context = context,
            state = FindSearchingMovies.getInstance()
        )
        context.searchMovie()
    }

    override fun selectMovie(context: FindContext) {
        changeState(
            context = context,
            state = FindOpenedDetail.getInstance()
        )
        context.openMovieDetail()
    }

    companion object {
        private var instance: FindState? = null

        fun getInstance(): FindState = instance ?: synchronized(this) {
            FindListingMovies().also { instance = it }
        }
    }
}