package com.tzion.jetpackmovies.data.cache

import androidx.paging.DataSource
import com.tzion.jetpackmovies.data.cache.database.DatabaseBuilder
import com.tzion.jetpackmovies.data.cache.model.CacheMovieDetail
import javax.inject.Inject

class CacheImpl @Inject constructor(private val databaseBuilder: DatabaseBuilder): Cache {

    override fun saveFavoriteMovie(movieDetail: CacheMovieDetail) {
        databaseBuilder.favoriteMovieDao().insertFavoriteMovie(movieDetail)
    }

    override fun getFavoriteMovies(): DataSource.Factory<Int, CacheMovieDetail> = databaseBuilder
        .favoriteMovieDao()
        .getFavoriteMovies()

}