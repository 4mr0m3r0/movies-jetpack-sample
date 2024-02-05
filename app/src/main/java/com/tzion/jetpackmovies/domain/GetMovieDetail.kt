package com.tzion.jetpackmovies.domain

import com.tzion.jetpackmovies.domain.gateway.NetworkGateway
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail.TomatoMeter.EMPTY
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail.TomatoMeter.FRESH
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail.TomatoMeter.ROTTEN
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class GetMovieDetail(private val networkGateway: NetworkGateway) {
    private val movie = MutableSharedFlow<DomainMovieDetail>()
    val movieOutput = movie.asSharedFlow()

    suspend fun getMovieDetailById(movieId: String?) {
        require(!movieId.isNullOrEmpty())
        val movieById = networkGateway.getMovieDetailById(movieId).also { it.addTomatoMeter() }
        movie.emit(movieById)
    }

    private fun DomainMovieDetail.addTomatoMeter(): DomainMovieDetail = try {
        val ratingNumber: Float = rating?.toFloat() ?: 0f
        when {
            ratingNumber >= 6f -> this.copy(tomatoMeter = FRESH)
            else -> this.copy(tomatoMeter = ROTTEN)
        }
    } catch (e: Exception) {
        this.copy(tomatoMeter = EMPTY)
    }
}
