package com.tzion.jetpackmovies.presentation.uistates

import com.tzion.jetpackmovies.presentation.model.MovieDetail

sealed interface MovieDetailUiState {
    data object Loading : MovieDetailUiState
    data class Display(val movieDetail: MovieDetail) : MovieDetailUiState
    data object Error : MovieDetailUiState
}
