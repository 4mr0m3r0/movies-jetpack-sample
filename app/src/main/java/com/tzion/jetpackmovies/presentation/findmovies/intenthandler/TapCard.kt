package com.tzion.jetpackmovies.presentation.findmovies.intenthandler

import com.tzion.jetpackmovies.presentation.findmovies.FindUserIntent
import com.tzion.jetpackmovies.presentation.findmovies.TapOnAMovieIntent

class TapCard(
    successor: FindIntentHandler? = null,
    private val userIntent: TapOnAMovieIntent,
) : FindIntentHandler(successor = successor) {
    override fun handleRequest(request: FindRequest, sendUserIntent: (userIntent: FindUserIntent) -> Unit) {
        if (request is FindRequest.TapCard) {
            sendUserIntent(userIntent)
        } else {
            super.handleRequest(request, sendUserIntent)
        }
    }
}