package com.tzion.jetpackmovies.domain.repository

import com.tzion.jetpackmovies.domain.model.DomainMovie
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun findMoviesByName(name: String): Flow<List<DomainMovie>>

    fun getMovieDetailById(movieId: String): Flow<DomainMovieDetail>

}