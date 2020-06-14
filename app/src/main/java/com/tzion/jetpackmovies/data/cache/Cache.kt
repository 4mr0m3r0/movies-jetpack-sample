package com.tzion.jetpackmovies.data.cache

import androidx.paging.DataSource
import com.tzion.jetpackmovies.data.cache.model.CacheMovieDetail

interface Cache {

    suspend fun saveFavoriteMovie(movieDetail: CacheMovieDetail)

    fun getFavoriteMovies(): DataSource.Factory<Int, CacheMovieDetail>

}