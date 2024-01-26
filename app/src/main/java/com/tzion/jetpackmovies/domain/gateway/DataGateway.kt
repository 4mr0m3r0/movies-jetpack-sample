package com.tzion.jetpackmovies.domain.gateway

import androidx.paging.DataSource
import com.tzion.jetpackmovies.domain.model.DomainFavoriteMovie

interface DataGateway {
    suspend fun saveFavoriteMovie(favoriteMovie: DomainFavoriteMovie)

    fun getFavoriteMovies(): DataSource.Factory<Int, DomainFavoriteMovie>
}
