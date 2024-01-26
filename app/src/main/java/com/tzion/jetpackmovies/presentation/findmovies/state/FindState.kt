package com.tzion.jetpackmovies.presentation.findmovies.state

interface FindState {
    fun start(context: FindContext) {}
    fun pressSearchButton(context: FindContext) {}
    fun noResults(context: FindContext) {}
    fun successfulResults(context: FindContext) {}
    fun searchFailed(context: FindContext) {}
    fun selectMovie(context: FindContext) {}
    fun changeState(context: FindContext, state: FindState) {
        context.changeState(state)
    }
}