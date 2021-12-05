package com.tzion.jetpackmovies.ui.movieDetail

import androidx.compose.runtime.Composable
import com.tzion.jetpackmovies.presentation.uistates.MovieDetailUiState
import com.tzion.jetpackmovies.presentation.uistates.MovieDetailUiState.DetailDisplayUiState
import com.tzion.jetpackmovies.presentation.uistates.MovieDetailUiState.ErrorUiState
import com.tzion.jetpackmovies.presentation.uistates.MovieDetailUiState.LoadingUiState
import com.tzion.jetpackmovies.ui.movieDetail.mapper.AttrsDetailMapper

@Composable
fun UiStateRender(uiState: MovieDetailUiState, mapper: AttrsDetailMapper) {
    when (uiState) {
        LoadingUiState -> Loading()
        is DetailDisplayUiState -> DetailDisplay(
            attributes = with(mapper) { uiState.movieDetail.toAttributes() }
        )
        ErrorUiState -> ErrorMessage()
    }
}
