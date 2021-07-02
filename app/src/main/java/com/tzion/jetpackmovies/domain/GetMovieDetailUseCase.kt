package com.tzion.jetpackmovies.domain

import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import com.tzion.jetpackmovies.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: Repository) {

    fun getMovieDetailById(movieId: String?): Flow<DomainMovieDetail> {
        require(!movieId.isNullOrEmpty())
        return repository.getMovieDetailById(movieId)
    }
}
