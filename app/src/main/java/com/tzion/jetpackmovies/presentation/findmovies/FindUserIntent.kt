package com.tzion.jetpackmovies.presentation.findmovies

import com.tzion.jetpackmovies.domain.ManageFavoriteMovies
import com.tzion.jetpackmovies.domain.model.DomainFavoriteMovie
import com.tzion.jetpackmovies.presentation.findmovies.state.FindStateMachine

interface FindUserIntent {
    suspend fun execute(stateMachine: FindStateMachine)
}

class EnterFindSectionIntent : FindUserIntent {
    override suspend fun execute(stateMachine: FindStateMachine) {
        stateMachine.start()
    }
}

class SearchMovieIntent : FindUserIntent {
    var query: String? = null
    override suspend fun execute(stateMachine: FindStateMachine) {
        stateMachine.pressSearchButton(query = query)
    }
}

class SelectMovieAsFavoriteIntent(private val manageFavoriteMovies: ManageFavoriteMovies) : FindUserIntent {
    var favoriteMovie: DomainFavoriteMovie? = null
    override suspend fun execute(stateMachine: FindStateMachine) {
        manageFavoriteMovies.saveFavoriteMovie(favoriteMovie = favoriteMovie)
    }
}

class TapOnAMovieIntent : FindUserIntent {
    override suspend fun execute(stateMachine: FindStateMachine) {
        stateMachine.tapMovie()
    }
}
