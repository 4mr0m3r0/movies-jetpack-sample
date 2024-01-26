package com.tzion.jetpackmovies.data

import androidx.paging.DataSource
import com.tzion.jetpackmovies.data.database.DatabaseBuilder
import com.tzion.jetpackmovies.data.mapper.DataFavoriteMovieMapper
import com.tzion.jetpackmovies.domain.gateway.DataGateway
import com.tzion.jetpackmovies.domain.model.DomainFavoriteMovie
import javax.inject.Inject

class DataRoom @Inject constructor(
    private val databaseBuilder: DatabaseBuilder,
    private val favoriteMovieMapper: DataFavoriteMovieMapper
) : DataGateway {

    override suspend fun saveFavoriteMovie(favoriteMovie: DomainFavoriteMovie) {
        databaseBuilder
            .favoriteMovieDao()
            .insertFavoriteMovie(
                with(favoriteMovieMapper) {
                    favoriteMovie.fromDomainToCache()
                }
            )
    }

    override fun getFavoriteMovies(): DataSource.Factory<Int, DomainFavoriteMovie> = databaseBuilder
        .favoriteMovieDao()
        .getFavoriteMovies()
        .map { cacheFavoriteMovie ->
            with(favoriteMovieMapper) { cacheFavoriteMovie.fromCacheToDomain() }
        }
}
