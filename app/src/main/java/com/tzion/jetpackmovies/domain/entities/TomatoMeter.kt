package com.tzion.jetpackmovies.domain.entities

class TomatoMeter {
    fun calculate(rating: String?): State = try {
        val ratingNumber: Float = rating?.toFloat() ?: 0f
        when {
            ratingNumber >= 6f -> State.FRESH
            else -> State.ROTTEN
        }
    } catch (e: Exception) {
        State.EMPTY
    }

    enum class State { FRESH, ROTTEN, EMPTY }
}