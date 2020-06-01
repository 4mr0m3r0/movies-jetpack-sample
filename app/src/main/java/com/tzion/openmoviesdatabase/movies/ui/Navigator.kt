package com.tzion.openmoviesdatabase.movies.ui

import android.content.Context
import com.tzion.openmoviesdatabase.movies.ui.movieDetail.MovieDetailActivity
import javax.inject.Inject

class Navigator @Inject constructor() {

    fun openMovieDetails(context: Context?, movieId: String) {
        context?.startActivity(MovieDetailActivity.makeIntent(context, movieId))
    }

}