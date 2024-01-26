package com.tzion.jetpackmovies.presentation.findmovies.handler

import com.tzion.jetpackmovies.presentation.findmovies.FindMoviesStateHolder

sealed interface FindIntentRequest {
    data class PressingSearchButton(val query: String, val viewModel: FindMoviesStateHolder) :
        FindIntentRequest
    data class PressingSearchKeyboard(val query: String, val viewModel: FindMoviesStateHolder) :
        FindIntentRequest
}