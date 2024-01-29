package com.tzion.jetpackmovies.presentation.findmovies.state

class FindEmptyScreen : FindState {
    override fun pressSearchButton(context: FindStateContext) {
        changeState(
            context = context,
            state = FindSearchingMovies.getInstance()
        )
        context.searchMovie()
    }

    companion object {
        private var instance: FindState? = null

        fun getInstance(): FindState = instance ?: synchronized(this) {
            FindInit().also { instance = it }
        }
    }
}