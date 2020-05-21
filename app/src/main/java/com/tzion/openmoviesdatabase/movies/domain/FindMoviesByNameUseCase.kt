package com.tzion.openmoviesdatabase.movies.domain

import androidx.lifecycle.LiveData
import com.tzion.openmoviesdatabase.movies.domain.model.DomainMovie
import com.tzion.openmoviesdatabase.movies.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class FindMoviesByNameUseCase @Inject constructor(private val repository: Repository) {

    fun findMovieByName(name: String?): Flow<List<DomainMovie>> {
        require(!name.isNullOrEmpty())
        return repository.findMoviesByName(name)
    }

}