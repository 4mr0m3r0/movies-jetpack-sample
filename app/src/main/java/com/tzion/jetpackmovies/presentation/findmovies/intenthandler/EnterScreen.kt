package com.tzion.jetpackmovies.presentation.findmovies.intenthandler

import com.tzion.jetpackmovies.presentation.findmovies.EnterFindSectionIntent
import com.tzion.jetpackmovies.presentation.findmovies.FindUserIntent

class EnterScreen(
    successor: FindIntentHandler? = null,
    private val userIntent: EnterFindSectionIntent,
) : FindIntentHandler(successor = successor) {
    override fun handleRequest(request: FindRequest, sendUserIntent: (userIntent: FindUserIntent) -> Unit) {
        if (request is FindRequest.EnterScreen) {
            sendUserIntent(userIntent)
        } else {
            super.handleRequest(request, sendUserIntent)
        }
    }
}