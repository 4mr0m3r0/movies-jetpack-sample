package com.tzion.jetpackmovies.presentation.search

sealed interface FindSideEffect {
    data class NavigateToDetail(val movieId: String) : FindSideEffect
}