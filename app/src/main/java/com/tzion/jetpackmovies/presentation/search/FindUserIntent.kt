package com.tzion.jetpackmovies.presentation.search

import com.tzion.jetpackmovies.domain.ManageFavoriteMovie
import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.presentation.search.state.FindStateMachine

interface FindUserIntent {
    suspend fun execute(stateMachine: FindStateMachine)
}

class SearchMovieIntent : FindUserIntent {
    var query: String? = null
    override suspend fun execute(stateMachine: FindStateMachine) {
        stateMachine.pressSearchButton(query = query)
    }
}

class SelectMovieAsFavoriteIntent(private val manageFavoriteMovie: ManageFavoriteMovie) : FindUserIntent {
    var favoriteMovie: Movie.Favorite? = null
    override suspend fun execute(stateMachine: FindStateMachine) {
        manageFavoriteMovie.saveFavoriteMovie(favoriteMovie = favoriteMovie)
    }
}

class TapOnAMovieIntent : FindUserIntent {
    var movieId: String? = null
    override suspend fun execute(stateMachine: FindStateMachine) {
        stateMachine.tapMovie(movieId = movieId)
    }
}
