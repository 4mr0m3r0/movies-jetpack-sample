package com.tzion.jetpackmovies.presentation.findmovies.handler

import com.tzion.jetpackmovies.presentation.findmovies.SearchMovie

class SearchTopBar(
    successor: FindIntentHandler? = null,
    private val userIntent: SearchMovie
) : FindIntentHandler(successor = successor) {
    override fun handleRequest(request: FindIntentRequest) {
        if (request is FindIntentRequest.PressingSearchButton) {
            userIntent.query = request.query
            request.viewModel.processUserIntent(userIntent)
        } else {
            super.handleRequest(request)
        }
    }
}