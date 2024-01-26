package com.tzion.jetpackmovies.domain

import com.tzion.jetpackmovies.domain.gateway.DataGateway
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail.TomatoMeter.EMPTY
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail.TomatoMeter.FRESH
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail.TomatoMeter.ROTTEN
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetMovieDetail(private val dataGateway: DataGateway) {

    fun getMovieDetailById(movieId: String?): Flow<DomainMovieDetail> {
        require(!movieId.isNullOrEmpty())
        return dataGateway.getMovieDetailById(movieId).map { it.addTomatoMeter() }
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
