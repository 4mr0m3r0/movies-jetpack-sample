package com.tzion.jetpackmovies.domain.posters.state

interface FindState {
    fun search(context: StateContext, query: String) {}
    fun emptiness(context: StateContext) {}
    fun posters(context: StateContext) {}
    fun searchFailed(context: StateContext, error: String?) {}
    fun changeState(context: StateContext, state: FindState) {
        context.changeState(state)
    }
}