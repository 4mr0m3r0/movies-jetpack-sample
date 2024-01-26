package com.tzion.jetpackmovies.domain

import androidx.paging.DataSource
import com.tzion.jetpackmovies.domain.gateway.DataGateway
import com.tzion.jetpackmovies.domain.model.DomainFavoriteMovie

class ManageFavoriteMovies(private val dataGateway: DataGateway) {
    lateinit var favoriteMovies: DataSource.Factory<Int, DomainFavoriteMovie>

    fun fetchFavoriteMovies() {
        favoriteMovies = dataGateway.getFavoriteMovies()
    }

    suspend fun saveFavoriteMovie(favoriteMovie: DomainFavoriteMovie?) {
        requireNotNull(favoriteMovie)
        return dataGateway.saveFavoriteMovie(favoriteMovie)
    }
}
