package com.tzion.jetpackmovies.presentation.uistates

import com.tzion.jetpackmovies.presentation.model.Movie

sealed class FindMoviesUiState {
    object LoadingUiSate : FindMoviesUiState()
    data class MoviesResultDisplayUiState(val movies: List<Movie>) : FindMoviesUiState()
    data class ErrorUiState(val throwable: Throwable) : FindMoviesUiState()
}
