package com.tzion.jetpackmovies.domain

import com.tzion.jetpackmovies.domain.boundary.RemoteFacade
import com.tzion.jetpackmovies.domain.entities.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class FindMoviesByName(
    private val remoteFacade: RemoteFacade,
    private val movie: Movie,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
    fun find(name: String?) = flow {
        val moviesFound: List<Movie.Poster> = withContext(dispatcher) {
            remoteFacade.findMoviePostersByName(name = movie.verifyAndGetCleanedName(name))
        }
        emit(moviesFound)
    }
}
