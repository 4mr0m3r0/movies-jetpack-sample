package com.tzion.jetpackmovies.presentation.uistates

import androidx.paging.PagedList
import com.tzion.jetpackmovies.presentation.model.UiFavoriteMovie

sealed class FavoriteMovieUiState(
    val loading: Boolean = false,
    val favoriteMovies: PagedList<UiFavoriteMovie>? = null,
    val error: Throwable? = null
) {

    object Loading : FavoriteMovieUiState(loading = true)

    data class Success(
        val uiFavoriteMovies: PagedList<UiFavoriteMovie>
    ) : FavoriteMovieUiState(favoriteMovies = uiFavoriteMovies)

    data class Error(val throwable: Throwable) : FavoriteMovieUiState(error = throwable)
}
