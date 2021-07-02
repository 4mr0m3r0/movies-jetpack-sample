package com.tzion.jetpackmovies.domain

import androidx.paging.DataSource
import com.tzion.jetpackmovies.domain.model.DomainFavoriteMovie
import com.tzion.jetpackmovies.domain.repository.Repository
import javax.inject.Inject

class ManageFavoriteMoviesUseCase @Inject constructor(private val repository: Repository) {

    fun getFavoriteMovies(): DataSource.Factory<Int, DomainFavoriteMovie> {
        return repository.getFavoriteMovies()
    }

    suspend fun saveFavoriteMovie(favoriteMovie: DomainFavoriteMovie) {
        return repository.saveFavoriteMovie(favoriteMovie)
    }
}
