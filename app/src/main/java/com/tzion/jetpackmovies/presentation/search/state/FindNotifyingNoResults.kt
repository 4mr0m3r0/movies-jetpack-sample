package com.tzion.jetpackmovies.presentation.search.state

class FindNotifyingNoResults : FindState {
    override fun pressSearchButton(context: FindStateContext) {
        changeState(
            context = context,
            state = FindSearchingMovies.getInstance()
        )
    }

    companion object {
        private var instance: FindState? = null

        fun getInstance(): FindState = instance ?: synchronized(this) {
            FindNotifyingNoResults().also { instance = it }
        }
    }
}