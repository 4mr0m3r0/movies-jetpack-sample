package com.tzion.jetpackmovies.presentation.findmovies

import com.tzion.jetpackmovies.domain.FindMoviesByName
import com.tzion.jetpackmovies.domain.ManageFavoriteMovies
import com.tzion.jetpackmovies.domain.model.DomainFavoriteMovie
import com.tzion.jetpackmovies.presentation.findmovies.state.FindStateMachine

interface FindUserIntent {
    suspend fun execute(stateMachine: FindStateMachine)
}

class EnterFindSection : FindUserIntent {
    override suspend fun execute(stateMachine: FindStateMachine) {
        stateMachine.start()
    }
}

class SearchMovie(private val useCase: FindMoviesByName) : FindUserIntent {
    var query: String? = null
    override suspend fun execute(stateMachine: FindStateMachine) {
        useCase.findMovieByName(name = query)
        stateMachine.pressSearchButton(moviesOutput = useCase.moviesOutput)
    }
}

class SelectAsFavorite(private val manageFavoriteMovies: ManageFavoriteMovies) : FindUserIntent {
    var favoriteMovie: DomainFavoriteMovie? = null
    override suspend fun execute(stateMachine: FindStateMachine) {
        manageFavoriteMovies.saveFavoriteMovie(favoriteMovie = favoriteMovie)
    }
}
