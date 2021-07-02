package com.tzion.jetpackmovies.data.cache

import androidx.paging.DataSource
import com.tzion.jetpackmovies.data.cache.model.CacheFavoriteMovie

interface Cache {

    suspend fun saveFavoriteMovie(favoriteMovie: CacheFavoriteMovie)

    fun getFavoriteMovies(): DataSource.Factory<Int, CacheFavoriteMovie>

}
