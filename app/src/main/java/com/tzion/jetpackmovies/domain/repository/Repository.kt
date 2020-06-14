package com.tzion.jetpackmovies.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.tzion.jetpackmovies.domain.model.DomainMovie
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun findMoviesByName(name: String): Flow<List<DomainMovie>>

    fun getMovieDetailById(movieId: String): Flow<DomainMovieDetail>

    suspend fun saveFavoriteMovie(movieDetail: DomainMovieDetail)

    fun getFavoriteMovies(): LiveData<PagedList<DomainMovieDetail>>

}