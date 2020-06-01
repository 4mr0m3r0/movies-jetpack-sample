package com.tzion.openmoviesdatabase.movies.presentation.uistates

import com.tzion.openmoviesdatabase.movies.presentation.model.UiMovieDetail

sealed class MovieDetailUiState(val loading: Boolean = false,
                                val movieDetail: UiMovieDetail = UiMovieDetail(),
                                val error: Throwable? = null) {

    object Loading: MovieDetailUiState(loading = true)

    data class Success(val uiMovieDetail: UiMovieDetail): MovieDetailUiState(movieDetail = uiMovieDetail)

    data class Error(val throwable: Throwable): MovieDetailUiState(error = throwable)
}