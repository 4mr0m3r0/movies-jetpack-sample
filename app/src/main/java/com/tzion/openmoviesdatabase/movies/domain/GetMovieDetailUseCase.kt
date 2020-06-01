package com.tzion.openmoviesdatabase.movies.domain

import com.tzion.openmoviesdatabase.movies.domain.model.DomainMovieDetail
import com.tzion.openmoviesdatabase.movies.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: Repository) {

    fun getMovieDetailById(movieId: String?): Flow<DomainMovieDetail> {
        require(!movieId.isNullOrEmpty())
        return repository.getMovieDetailById(movieId)
    }

}