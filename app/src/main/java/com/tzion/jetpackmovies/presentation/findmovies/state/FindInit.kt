package com.tzion.jetpackmovies.presentation.findmovies.state

class FindInit : FindState {
    override fun start(context: FindStateContext) {
        changeState(
            context = context,
            state = FindEmptyScreen.getInstance()
        )
        context.displayEmptyScreen()
    }

    companion object {
        private var instance: FindState? = null

        fun getInstance(): FindState = instance ?: synchronized(this) {
            FindInit().also { instance = it }
        }
    }
}
