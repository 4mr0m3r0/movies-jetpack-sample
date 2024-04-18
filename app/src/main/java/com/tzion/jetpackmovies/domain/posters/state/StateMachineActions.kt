package com.tzion.jetpackmovies.domain.posters.state

interface StateMachineActions {
    fun searchPosters(query: String) {}
    fun notifyNoPosters() {}
}
