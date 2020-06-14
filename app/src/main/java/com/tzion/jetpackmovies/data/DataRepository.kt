package com.tzion.jetpackmovies.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.tzion.jetpackmovies.data.cache.Cache
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
    private val cache: Cache,
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

    override fun saveFavoriteMovie(movieDetail: DomainMovieDetail) {
        cache.saveFavoriteMovie(with(dataMovieDetailMapper) { movieDetail.fromDomainToCache() })
    }

    override fun getFavoriteMovies(): LiveData<PagedList<DomainMovieDetail>> =
        LivePagedListBuilder(cache.getFavoriteMovies().mapByPage { cacheMovieDetails ->
            with(dataMovieDetailMapper) { cacheMovieDetails.fromCacheToDomain() }
        }, DATABASE_PAGE_SIZE).build()

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
    }

}