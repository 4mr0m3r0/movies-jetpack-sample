package com.tzion.jetpackmovies.domain

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.tzion.jetpackmovies.domain.model.DomainFavoriteMovie
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import com.tzion.jetpackmovies.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ManageFavoriteMoviesUseCase @Inject constructor(private val repository: Repository) {

    fun getFavoriteMovies(): DataSource.Factory<Int, DomainFavoriteMovie> {
        return repository.getFavoriteMovies()
    }

    suspend fun saveFavoriteMovie(favoriteMovie: DomainFavoriteMovie) {
        //TODO: verify movieDetail main attrs are not empty
        return repository.saveFavoriteMovie(favoriteMovie)
    }

}