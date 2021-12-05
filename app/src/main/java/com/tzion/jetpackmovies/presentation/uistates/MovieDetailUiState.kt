package com.tzion.jetpackmovies.presentation.uistates

import com.tzion.jetpackmovies.presentation.model.MovieDetail

sealed class MovieDetailUiState {
    object LoadingUiState : MovieDetailUiState()
    data class DetailDisplayUiState(val movieDetail: MovieDetail) : MovieDetailUiState()
    object ErrorUiState : MovieDetailUiState()
}
