package com.tzion.jetpackmovies.data

import com.tzion.jetpackmovies.data.mapper.DataMovieDetailMapper
import com.tzion.jetpackmovies.data.mapper.DataMovieMapper
import com.tzion.jetpackmovies.data.remote.Remote
import com.tzion.jetpackmovies.domain.model.DomainMovie
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import com.tzion.jetpackmovies.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val remote: Remote,
    private val dataMovieMapper: DataMovieMapper,
    private val dataMovieDetailMapper: DataMovieDetailMapper): Repository {

    override fun findMoviesByName(name: String): Flow<List<DomainMovie>> = remote
        .findMoviesByName(name)
        .map { remoteSearch ->
            with(dataMovieMapper) { remoteSearch.fromRemoteToDomain() }
        }

    override fun getMovieDetailById(movieId: String): Flow<DomainMovieDetail> = remote
        .getMovieDetailById(movieId)
        .map { remoteMovieDetail ->
            with(dataMovieDetailMapper) { remoteMovieDetail.fromRemoteToDomain() }
        }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }

}