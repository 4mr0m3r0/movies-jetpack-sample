package com.tzion.jetpackmovies.presentation.findmovies.intenthandler

import com.tzion.jetpackmovies.presentation.findmovies.FindUserIntent

open class FindIntentHandler(private val successor: FindIntentHandler? = null, ) {
    open fun handleRequest(request: FindRequest, sendUserIntent: (userIntent: FindUserIntent) -> Unit) {
        successor?.handleRequest(request, sendUserIntent)
    }
}