package com.tzion.jetpackmovies.presentation.findmovies.handler

import com.tzion.jetpackmovies.presentation.userintent.SearchesMovie

class SearchTopBar(
    successor: FindIntentHandler? = null,
    private val userIntent: SearchesMovie
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