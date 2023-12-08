package com.tzion.jetpackmovies.domain

import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail.TomatoMeter.EMPTY
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail.TomatoMeter.FRESH
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail.TomatoMeter.ROTTEN
import com.tzion.jetpackmovies.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: Repository) {

    fun getMovieDetailById(movieId: String?): Flow<DomainMovieDetail> {
        require(!movieId.isNullOrEmpty())
        return repository.getMovieDetailById(movieId).map { it.addTomatoMeter() }
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
