package com.tzion.jetpackmovies.presentation.userintent

import com.tzion.jetpackmovies.domain.FindMoviesByName
import com.tzion.jetpackmovies.domain.GetMovieDetail
import com.tzion.jetpackmovies.domain.ManageFavoriteMovies
import com.tzion.jetpackmovies.domain.model.DomainFavoriteMovie

interface UserIntent {
    suspend fun execute()
}

class SearchesMovie(private val useCase: FindMoviesByName) : UserIntent {
    var query: String? = null
    override suspend fun execute() {
        useCase.findMovieByName(name = query)
    }
}

class EntersDetailSection(private val getMovieDetail: GetMovieDetail) : UserIntent {
    var movieId: String? = null
    override suspend fun execute() {
        getMovieDetail.getMovieDetailById(movieId = movieId)
    }
}

class SelectsAsFavorite(private val manageFavoriteMovies: ManageFavoriteMovies) : UserIntent {
    var favoriteMovie: DomainFavoriteMovie? = null
    override suspend fun execute() {
        manageFavoriteMovies.saveFavoriteMovie(favoriteMovie = favoriteMovie)
    }
}

class EntersFavoriteSection(private val manageFavoriteMovies: ManageFavoriteMovies) : UserIntent {
    override suspend fun execute() {
        manageFavoriteMovies.fetchFavoriteMovies()
    }
}
