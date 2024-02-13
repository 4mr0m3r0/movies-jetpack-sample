package com.tzion.jetpackmovies.domain

import com.tzion.jetpackmovies.domain.boundary.RemoteFacade
import com.tzion.jetpackmovies.domain.entities.Movie
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class SeeMovieDetail(
    private val remoteFacade: RemoteFacade,
    private val movie: Movie,
) {
    private val _movieOutput = MutableSharedFlow<Movie.Information>()
    val movieOutput = _movieOutput.asSharedFlow()

    suspend fun getMovieDetailById(movieId: String?) {
        require(!movieId.isNullOrEmpty())
        val detail = remoteFacade.getMovieDetailById(movieId)
        val information = movie.updateWithTomatoMeter(information = detail)
        _movieOutput.emit(information)
    }
}
