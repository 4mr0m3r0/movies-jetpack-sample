package com.tzion.jetpackmovies.domain.posters.state

class Searching : FindState {
    override fun emptiness(context: StateContext) {
        changeState(
            context = context,
            state = Emptiness.getInstance()
        )
        context.notifyNoPosters()
    }

    override fun posters(context: StateContext) {
        changeState(
            context = context,
            state = PagingPosters.getInstance()
        )
//        context.updatePagingPosters(posters)
    }

//    override fun searchFailed(context: StateContext, error: String?) {
//        changeState(
//            context = context,
//            state = FindNotifyingError.getInstance()
//        )
//        context.displayErrorScreen(error)
//    }

    companion object {
        private var instance: FindState? = null

        fun getInstance(): FindState = instance ?: synchronized(this) {
            Searching().also { instance = it }
        }
    }
}
