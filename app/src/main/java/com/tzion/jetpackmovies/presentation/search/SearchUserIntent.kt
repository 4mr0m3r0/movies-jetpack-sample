package com.tzion.jetpackmovies.presentation.search

sealed interface SearchUserIntent {
    data class FindByTitle(val query: String) : SearchUserIntent
    data object SelectPosterAsFavorite : SearchUserIntent
    data class TapOnPoster(val posterId: String) : SearchUserIntent
}
