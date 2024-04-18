package com.tzion.jetpackmovies.domain.posters.state

class PagingPosters : FindState {
    override fun search(context: StateContext, query: String) {
        changeState(
            context = context,
            state = Searching.getInstance()
        )
        context.searchPosters(query)
    }

    companion object {
        private var instance: FindState? = null

        fun getInstance(): FindState = instance ?: synchronized(this) {
            PagingPosters().also { instance = it }
        }
    }
}