package com.tzion.jetpackmovies.domain.gateway

import com.tzion.jetpackmovies.domain.model.DomainMovie
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail

interface NetworkGateway {
    suspend fun findMoviesByName(name: String): List<DomainMovie>

    suspend fun getMovieDetailById(movieId: String): DomainMovieDetail
}