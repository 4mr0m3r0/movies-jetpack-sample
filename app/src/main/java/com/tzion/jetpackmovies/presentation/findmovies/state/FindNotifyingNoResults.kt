package com.tzion.jetpackmovies.presentation.findmovies.state

class FindNotifyingNoResults : FindState {
    override fun pressSearchButton(context: FindContext) {
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