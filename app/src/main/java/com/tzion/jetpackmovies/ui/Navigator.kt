package com.tzion.jetpackmovies.ui

import android.content.Context
import com.tzion.jetpackmovies.ui.movieDetail.MovieDetailActivity
import javax.inject.Inject

class Navigator @Inject constructor() {

    fun openMovieDetails(context: Context?, movieId: String) {
        context?.startActivity(MovieDetailActivity.makeIntent(context, movieId))
    }

}