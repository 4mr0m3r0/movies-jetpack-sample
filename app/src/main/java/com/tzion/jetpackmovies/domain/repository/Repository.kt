package com.tzion.jetpackmovies.domain.repository

import androidx.paging.DataSource
import com.tzion.jetpackmovies.domain.model.DomainFavoriteMovie
import com.tzion.jetpackmovies.domain.model.DomainMovie
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun findMoviesByName(name: String): Flow<List<DomainMovie>>

    fun getMovieDetailById(movieId: String): Flow<DomainMovieDetail>

    suspend fun saveFavoriteMovie(favoriteMovie: DomainFavoriteMovie)

    fun getFavoriteMovies(): DataSource.Factory<Int, DomainFavoriteMovie>
}
