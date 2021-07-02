package com.tzion.jetpackmovies.data

import androidx.paging.DataSource
import com.tzion.jetpackmovies.data.cache.Cache
import com.tzion.jetpackmovies.data.mapper.DataFavoriteMovieMapper
import com.tzion.jetpackmovies.data.mapper.DataMovieDetailMapper
import com.tzion.jetpackmovies.data.mapper.DataMovieMapper
import com.tzion.jetpackmovies.data.remote.Remote
import com.tzion.jetpackmovies.domain.model.DomainFavoriteMovie
import com.tzion.jetpackmovies.domain.model.DomainMovie
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import com.tzion.jetpackmovies.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val remote: Remote,
    private val cache: Cache,
    private val movieMapper: DataMovieMapper,
    private val movieDetailMapper: DataMovieDetailMapper,
    private val favoriteMovieMapper: DataFavoriteMovieMapper
) : Repository {

    override fun findMoviesByName(name: String): Flow<List<DomainMovie>> = remote
        .findMoviesByName(name)
        .map { remoteSearch ->
            with(movieMapper) { remoteSearch.fromRemoteToDomain() }
        }

    override fun getMovieDetailById(movieId: String): Flow<DomainMovieDetail> = remote
        .getMovieDetailById(movieId)
        .map { remoteMovieDetail ->
            with(movieDetailMapper) { remoteMovieDetail.fromRemoteToDomain() }
        }

    override suspend fun saveFavoriteMovie(favoriteMovie: DomainFavoriteMovie) {
        cache.saveFavoriteMovie(with(favoriteMovieMapper) { favoriteMovie.fromDomainToCache() })
    }

    override fun getFavoriteMovies(): DataSource.Factory<Int, DomainFavoriteMovie> =
        cache.getFavoriteMovies().map { cacheFavoriteMovie ->
            with(favoriteMovieMapper) {
                cacheFavoriteMovie.fromCacheToDomain()
            }
        }
}
