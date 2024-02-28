package com.tzion.jetpackmovies.presentation.search.intenthandler

import com.tzion.jetpackmovies.presentation.search.FindUserIntent
import com.tzion.jetpackmovies.presentation.search.SearchMovieIntent

class SearchKeyboard(
    successor: FindIntentHandler? = null,
    private val userIntent: SearchMovieIntent
) : FindIntentHandler(successor = successor) {
    override fun handleRequest(request: FindRequest, sendUserIntent: (userIntent: FindUserIntent) -> Unit) {
        if (request is FindRequest.SearchKeyboard) {
            userIntent.query = request.query
            sendUserIntent(userIntent)
        } else {
            super.handleRequest(request, sendUserIntent)
        }
    }
}
