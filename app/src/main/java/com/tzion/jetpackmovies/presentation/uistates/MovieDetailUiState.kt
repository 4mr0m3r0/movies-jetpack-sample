package com.tzion.jetpackmovies.presentation.uistates

import com.tzion.jetpackmovies.uicomponent.template.AttrsDetailTemplate

sealed interface MovieDetailUiState {
    data object Loading : MovieDetailUiState
    data class Display(val attributes: AttrsDetailTemplate) : MovieDetailUiState
    data object Error : MovieDetailUiState
}
