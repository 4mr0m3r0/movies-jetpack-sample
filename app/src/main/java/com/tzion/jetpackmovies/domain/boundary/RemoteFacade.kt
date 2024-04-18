package com.tzion.jetpackmovies.domain.boundary

import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.domain.posters.pager.PagingInfo

interface RemoteFacade {
    val pageSize: Int
    suspend fun findMoviePostersByName(name: String, page: Int): PagingInfo
    suspend fun getMovieDetailById(movieId: String): Movie.Information
}