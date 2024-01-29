package com.tzion.jetpackmovies.presentation.findmovies

import com.tzion.jetpackmovies.presentation.model.Movie

sealed interface FindUserInterface {
    data class ScreenState(
        val isLoading: Boolean = false,
        val movies: List<Movie> = emptyList(),
        val thereAreNoResults: Boolean = false,
        val errorMessage: String? = null,
        val isEmptyScreen: Boolean = false
    ) : FindUserInterface
    data object NavigateToDetail : FindUserInterface
}

