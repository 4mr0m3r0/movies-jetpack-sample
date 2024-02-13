package com.tzion.jetpackmovies.presentation.findmovies.state

import android.content.Context
import com.tzion.jetpackmovies.R

class FindListingMovies : FindState {
    override fun pressSearchButton(context: FindStateContext) {
        changeState(
            context = context,
            state = FindSearchingMovies.getInstance()
        )
        context.searchMovie()
    }

    override fun selectMovie(context: FindStateContext, movieId: String?, content: Context) {
        if (movieId.isNullOrEmpty()) {
            changeState(
                context = context,
                state = FindNotifyingError.getInstance(),
            )
            context.displayErrorScreen(content.getString(R.string.current_movie_does_not_have))
        } else {
            changeState(
                context = context,
                state = FindOpenedDetail.getInstance()
            )
            context.openMovieDetail(movieId)
        }
    }

    companion object {
        private var instance: FindState? = null

        fun getInstance(): FindState = instance ?: synchronized(this) {
            FindListingMovies().also { instance = it }
        }
    }
}