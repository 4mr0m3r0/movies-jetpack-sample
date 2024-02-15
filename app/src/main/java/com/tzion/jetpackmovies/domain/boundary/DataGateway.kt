package com.tzion.jetpackmovies.domain.boundary

import androidx.paging.DataSource
import com.tzion.jetpackmovies.domain.entities.Movie

interface DataGateway {
    suspend fun saveFavoriteMovie(favoriteMovie: Movie.Favorite)

    fun getFavoriteMovies(): DataSource.Factory<Int, Movie.Favorite>
}
