package com.tzion.jetpackmovies.presentation.uistates

import com.tzion.jetpackmovies.presentation.model.UiMovie

sealed class FindMoviesUiState(val loading: Boolean = false,
                               val movies: List<UiMovie> = arrayListOf(),
                               val error: Throwable? = null) {

    object Loading: FindMoviesUiState(loading = true)

    data class Success(val uiMovies: List<UiMovie>): FindMoviesUiState(movies = uiMovies)

    data class Error(val throwable: Throwable): FindMoviesUiState(error = throwable)

}