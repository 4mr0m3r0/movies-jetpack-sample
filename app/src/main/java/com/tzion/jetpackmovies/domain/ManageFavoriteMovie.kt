package com.tzion.jetpackmovies.domain

import androidx.paging.DataSource
import com.tzion.jetpackmovies.domain.boundary.DataGateway
import com.tzion.jetpackmovies.domain.entities.Movie

class ManageFavoriteMovie(private val dataGateway: DataGateway) {
    lateinit var favoriteMovies: DataSource.Factory<Int, Movie.Favorite>

    fun fetchFavoriteMovies() {
        favoriteMovies = dataGateway.getFavoriteMovies()
    }

    suspend fun saveFavoriteMovie(favoriteMovie: Movie.Favorite?) {
        requireNotNull(favoriteMovie)
        return dataGateway.saveFavoriteMovie(favoriteMovie)
    }
}
