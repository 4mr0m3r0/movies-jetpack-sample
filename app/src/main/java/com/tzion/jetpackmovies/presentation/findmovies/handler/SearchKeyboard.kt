package com.tzion.jetpackmovies.presentation.findmovies.handler

import com.tzion.jetpackmovies.presentation.findmovies.SearchMovie

class SearchKeyboard(
    successor: FindIntentHandler? = null,
    private val userIntent: SearchMovie
) : FindIntentHandler(successor = successor) {
    override fun handleRequest(request: FindIntentRequest) {
        if (request is FindIntentRequest.PressingSearchKeyboard) {
            userIntent.query = request.query
            request.viewModel.processUserIntent(userIntent)
        } else {
            super.handleRequest(request)
        }
    }
}
