package com.tzion.jetpackmovies.presentation.findmovies

import com.tzion.jetpackmovies.presentation.model.ViewPoster

data class FindUserInterface(
    val isLoading: Boolean = false,
    val posters: List<ViewPoster> = emptyList(),
    val thereAreNoResults: Boolean = false,
    val errorMessage: String? = null,
    val isEmptyScreen: Boolean = false
) {
    companion object {
        fun default() = FindUserInterface(isEmptyScreen = true)
    }
}

