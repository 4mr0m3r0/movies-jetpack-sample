package com.tzion.jetpackmovies.domain

import com.tzion.jetpackmovies.domain.boundary.RemoteFacade
import com.tzion.jetpackmovies.domain.entities.Movie

class SeeMovieDetail(
    private val remoteFacade: RemoteFacade,
    private val movie: Movie,
) {
    suspend fun getMovieDetailById(movieId: String?): Movie.Information {
        require(!movieId.isNullOrEmpty())
        val detail = remoteFacade.getMovieDetailById(movieId)
        return movie.updateWithTomatoMeter(information = detail)
    }
}
