package com.tzion.jetpackmovies.presentation.findmovies.intenthandler

sealed interface FindRequest {
    data class SearchButton(val query: String) : FindRequest
    data class SearchKeyboard(val query: String) : FindRequest
    data class TapCard(val movieId: String) : FindRequest
}
