package com.tzion.jetpackmovies.presentation.search.intenthandler

import com.tzion.jetpackmovies.presentation.search.FindUserIntent
import com.tzion.jetpackmovies.presentation.search.TapOnAMovieIntent

class TapCard(
    successor: FindIntentHandler? = null,
    private val userIntent: TapOnAMovieIntent,
) : FindIntentHandler(successor = successor) {
    override fun handleRequest(request: FindRequest, sendUserIntent: (userIntent: FindUserIntent) -> Unit) {
        if (request is FindRequest.TapCard) {
            userIntent.movieId = request.movieId
            sendUserIntent(userIntent)
        } else {
            super.handleRequest(request, sendUserIntent)
        }
    }
}