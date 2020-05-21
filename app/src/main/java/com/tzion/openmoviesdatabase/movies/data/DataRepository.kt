package com.tzion.openmoviesdatabase.movies.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.tzion.openmoviesdatabase.movies.data.mapper.DataMovieMapper
import com.tzion.openmoviesdatabase.movies.data.source.DataSourceFactory
import com.tzion.openmoviesdatabase.movies.domain.repository.Repository
import com.tzion.openmoviesdatabase.movies.domain.model.DomainMovie
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val factory: DataSourceFactory,
    private val dataDataMovieMapper: DataMovieMapper): Repository {

    override fun findMoviesByName(name: String?): Flow<List<DomainMovie>> = factory
        .getRemote()
        .findMoviesByName(name)
        .map { remoteSearch ->
            with(dataDataMovieMapper) { remoteSearch.fromRemoteToDomain() }
        }

}