package com.tzion.jetpackmovies.presentation.favoritemovies

import com.tzion.jetpackmovies.domain.ManageFavoriteMovies
import com.tzion.jetpackmovies.presentation.UserIntent

class EnterFavoriteSection(private val manageFavoriteMovies: ManageFavoriteMovies) : UserIntent {
    override suspend fun execute() {
        manageFavoriteMovies.fetchFavoriteMovies()
    }
}
