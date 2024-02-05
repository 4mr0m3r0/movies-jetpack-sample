package com.tzion.jetpackmovies.presentation.findmovies.state

import com.tzion.jetpackmovies.presentation.model.Movie

interface FindStateMachineActions {
    fun displayEmptyScreen() {}
    fun searchMovie() {}
    fun displayNoResultsScreen() {}
    fun displayMovies(movies: List<Movie>) {}
    fun displayErrorScreen(error: String?) {}
    fun openMovieDetail() {}
}
