package com.tzion.jetpackmovies.domain.boundary

import com.tzion.jetpackmovies.domain.entities.Movie

interface RemoteFacade {
    suspend fun findMoviePostersByName(name: String): List<Movie.Poster>

    suspend fun getMovieDetailById(movieId: String): Movie.Information
}