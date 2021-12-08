package com.tzion.jetpackmovies.ui.findMovies

import androidx.compose.runtime.Composable
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState.DefaultUiState
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState.ErrorUiState
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState.LoadingUiSate
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState.MoviesResultDisplayUiState

@Composable
fun UiStateRender(uiState: FindMoviesUiState) {
    when (uiState) {
        DefaultUiState -> DefaultScreenDisplay()
        LoadingUiSate -> MoviesResultDisplay(isLoading = true)
        is MoviesResultDisplayUiState -> MoviesResultDisplay(movies = uiState.movies)
        is ErrorUiState -> ErrorMessage(message = uiState.throwable.localizedMessage)
    }
}
