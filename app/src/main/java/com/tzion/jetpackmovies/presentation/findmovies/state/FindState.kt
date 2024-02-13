package com.tzion.jetpackmovies.presentation.findmovies.state

import android.content.Context
import com.tzion.jetpackmovies.presentation.model.ViewPoster

interface FindState {
    fun pressSearchButton(context: FindStateContext) {}
    fun noResults(context: FindStateContext) {}
    fun successfulResults(context: FindStateContext, posters: List<ViewPoster>) {}
    fun searchFailed(context: FindStateContext, error: String?) {}
    fun selectMovie(context: FindStateContext, movieId: String?, content: Context) {}
    fun changeState(context: FindStateContext, state: FindState) {
        context.changeState(state)
    }
}