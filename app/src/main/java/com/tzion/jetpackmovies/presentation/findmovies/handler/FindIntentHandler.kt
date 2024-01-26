package com.tzion.jetpackmovies.presentation.findmovies.handler

open class FindIntentHandler(private val successor: FindIntentHandler? = null) {
    open fun handleRequest(request: FindIntentRequest) {
        successor?.handleRequest(request)
    }
}