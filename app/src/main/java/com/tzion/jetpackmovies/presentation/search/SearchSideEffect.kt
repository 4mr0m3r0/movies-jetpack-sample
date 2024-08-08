package com.tzion.jetpackmovies.presentation.search

sealed interface SearchSideEffect {
    data class UnexpectedError(val message: String) : SearchSideEffect
    data class NoResults(val queryRequested: String) : SearchSideEffect
}
