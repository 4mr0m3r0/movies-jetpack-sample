package com.tzion.jetpackmovies.presentation.findmovies

sealed interface FindSideEffect {
    data class NavigateToDetail(val movieId: String) : FindSideEffect
}