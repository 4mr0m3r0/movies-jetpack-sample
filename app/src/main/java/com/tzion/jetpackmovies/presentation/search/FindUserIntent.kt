package com.tzion.jetpackmovies.presentation.search

import androidx.paging.PagingData
import com.tzion.jetpackmovies.domain.ManageFavoriteMovie
import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.domain.posters.FindMoviePosters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

interface FindUserIntent {
    suspend fun execute()
}

class SearchMovieIntent(private val findMoviePosters: FindMoviePosters) : FindUserIntent {
    var query: String? = null
    var pagingPosters: Flow<PagingData<Movie.Poster>> = emptyFlow()
        private set
    override suspend fun execute() {
        pagingPosters = findMoviePosters.findByTitle(title = query)
    }
}

class SelectMovieAsFavoriteIntent(private val manageFavoriteMovie: ManageFavoriteMovie) : FindUserIntent {
    var favoriteMovie: Movie.Favorite? = null
    override suspend fun execute() {
        manageFavoriteMovie.saveFavoriteMovie(favoriteMovie = favoriteMovie)
    }
}

class TapOnAMovieIntent : FindUserIntent {
    var movieId: String? = null
    override suspend fun execute() {
//        stateMachine.tapMovie(movieId = movieId)
    }
}

class ScrollIntent : FindUserIntent {
    var query: String? = null
    override suspend fun execute() {
        TODO("Not yet implemented")
    }
}
