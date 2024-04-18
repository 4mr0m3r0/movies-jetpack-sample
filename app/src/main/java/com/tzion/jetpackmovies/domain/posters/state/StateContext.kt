package com.tzion.jetpackmovies.domain.posters.state

open class StateContext : StateMachineActions {
    private val initState: FindState = Emptiness.getInstance()
    protected var state = initState

    fun search(query: String) {
        state.search(this, query)
    }
    fun emptiness() {
        state.emptiness(this)
    }
    fun posters() {
        state.posters(context = this)
    }
    fun searchFailed(error: String?) {
        state.searchFailed(context = this, error = error)
    }
    fun changeState(state: FindState) {
        this.state = state
    }
}