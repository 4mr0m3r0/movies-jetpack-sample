package com.tzion.jetpackmovies.presentation.search.state

import com.tzion.jetpackmovies.presentation.model.ViewPoster

interface FindStateMachineActions {
    fun searchMovie() {}
    fun displayNoResultsScreen() {}
    fun displayMovies(posters: List<ViewPoster>) {}
    fun displayErrorScreen(error: String?) {}
    fun openMovieDetail(movieId: String) {}
}
