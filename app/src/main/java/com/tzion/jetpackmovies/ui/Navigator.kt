package com.tzion.jetpackmovies.ui

import android.view.View
import androidx.navigation.findNavController
import com.tzion.jetpackmovies.ui.findMovies.FindMoviesByNameFragmentDirections
import javax.inject.Inject

class Navigator @Inject constructor() {

    fun openMovieDetails(view: View?, movieId: String) {
        val action = FindMoviesByNameFragmentDirections.actionFindMoviesByNameToMovieDetail(movieId)
        view?.findNavController()?.navigate(action)
    }

//    fun openMovieDetails(view: View?, favoriteMovie: UiFavoriteMovie) {
//        val action = FindMoviesByNameFragmentDirections.actionFindMoviesByNameToMovieDetail(movieId)
//        view?.findNavController()?.navigate(action)
//    }

}
