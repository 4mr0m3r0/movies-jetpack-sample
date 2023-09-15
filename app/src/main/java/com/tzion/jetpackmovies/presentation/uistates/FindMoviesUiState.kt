package com.tzion.jetpackmovies.presentation.uistates

import com.tzion.jetpackmovies.presentation.model.Movie

sealed class FindMoviesUiState {
    object DefaultUiState : FindMoviesUiState()
    data class MoviesDisplayUiState(val screenState: MovieScreenState) : FindMoviesUiState()
    data class ErrorUiState(val throwable: Throwable) : FindMoviesUiState()
}

data class MovieScreenState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList()
)
