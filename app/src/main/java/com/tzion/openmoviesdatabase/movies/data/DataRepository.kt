package com.tzion.openmoviesdatabase.movies.data

import com.tzion.openmoviesdatabase.movies.data.mapper.DataMovieDetailMapper
import com.tzion.openmoviesdatabase.movies.data.mapper.DataMovieMapper
import com.tzion.openmoviesdatabase.movies.data.source.DataSourceFactory
import com.tzion.openmoviesdatabase.movies.domain.model.DomainMovie
import com.tzion.openmoviesdatabase.movies.domain.model.DomainMovieDetail
import com.tzion.openmoviesdatabase.movies.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val factory: DataSourceFactory,
    private val dataMovieMapper: DataMovieMapper,
    private val dataMovieDetailMapper: DataMovieDetailMapper): Repository {

    override fun findMoviesByName(name: String): Flow<List<DomainMovie>> = factory
        .getRemote()
        .findMoviesByName(name)
        .map { remoteSearch ->
            with(dataMovieMapper) { remoteSearch.fromRemoteToDomain() }
        }

    override fun getMovieDetailById(movieId: String): Flow<DomainMovieDetail> = factory
        .getRemote()
        .getMovieDetailById(movieId)
        .map { remoteMovieDetail ->
            with(dataMovieDetailMapper) { remoteMovieDetail.fromRemoteToDomain() }
        }

}