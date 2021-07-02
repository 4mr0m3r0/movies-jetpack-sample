package com.tzion.jetpackmovies.data.cache

import androidx.paging.DataSource
import com.tzion.jetpackmovies.data.cache.database.DatabaseBuilder
import com.tzion.jetpackmovies.data.cache.model.CacheFavoriteMovie
import javax.inject.Inject

class CacheImpl @Inject constructor(private val databaseBuilder: DatabaseBuilder) : Cache {

    override suspend fun saveFavoriteMovie(favoriteMovie: CacheFavoriteMovie) {
        databaseBuilder.favoriteMovieDao().insertFavoriteMovie(favoriteMovie)
    }

    override fun getFavoriteMovies(): DataSource.Factory<Int, CacheFavoriteMovie> = databaseBuilder
        .favoriteMovieDao()
        .getFavoriteMovies()
}
