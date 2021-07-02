package com.tzion.jetpackmovies.domain

import com.tzion.jetpackmovies.domain.model.DomainMovie
import com.tzion.jetpackmovies.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class FindMoviesByNameUseCase @Inject constructor(private val repository: Repository) {

    fun findMovieByName(name: String?): Flow<List<DomainMovie>> {
        require(!name.isNullOrEmpty())
        return repository.findMoviesByName(name)
    }
}
