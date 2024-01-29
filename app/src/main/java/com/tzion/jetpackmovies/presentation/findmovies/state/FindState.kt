package com.tzion.jetpackmovies.presentation.findmovies.state

import com.tzion.jetpackmovies.presentation.model.Movie

interface FindState {
    fun start(context: FindStateContext) {}
    fun pressSearchButton(context: FindStateContext) {}
    fun noResults(context: FindStateContext) {}
    fun successfulResults(context: FindStateContext, movies: List<Movie>) {}
    fun searchFailed(context: FindStateContext) {}
    fun selectMovie(context: FindStateContext) {}
    fun changeState(context: FindStateContext, state: FindState) {
        context.changeState(state)
    }
}