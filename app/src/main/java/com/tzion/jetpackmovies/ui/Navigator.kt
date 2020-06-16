package com.tzion.jetpackmovies.ui

import android.content.Context
import android.view.View
import androidx.navigation.findNavController
import com.tzion.jetpackmovies.ui.findMovies.FindMoviesByNameFragmentDirections
import com.tzion.jetpackmovies.ui.movieDetail.MovieDetailFragment
import javax.inject.Inject

class Navigator @Inject constructor() {

    fun openMovieDetails(view: View?, movieId: String) {
        val action = FindMoviesByNameFragmentDirections.actionFindMoviesByNameToMovieDetail(movieId)
        view?.findNavController()?.navigate(action)
    }

}