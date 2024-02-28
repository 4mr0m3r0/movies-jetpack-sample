package com.tzion.jetpackmovies.presentation.search.state

class FindNotifyingError : FindState {
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
            FindNotifyingError().also { instance = it }
        }
    }
}