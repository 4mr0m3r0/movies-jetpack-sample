package com.tzion.jetpackmovies.presentation.favoritemovies

import com.tzion.jetpackmovies.domain.ManageFavoriteMovie

class EnterFavoriteSection(private val manageFavoriteMovie: ManageFavoriteMovie) : UserIntent {
    override suspend fun execute() {
        manageFavoriteMovie.fetchFavoriteMovies()
    }
}
