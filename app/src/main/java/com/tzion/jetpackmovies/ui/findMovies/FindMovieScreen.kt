package com.tzion.jetpackmovies.ui.findMovies

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.FindMoviesViewModel
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState.DefaultUiState
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState.ErrorUiState
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState.MoviesDisplayUiState
import com.tzion.jetpackmovies.ui.findMovies.composable.DefaultDisplay
import com.tzion.jetpackmovies.ui.findMovies.composable.ErrorMessage
import com.tzion.jetpackmovies.ui.findMovies.composable.FindMovieTopAppBar
import com.tzion.jetpackmovies.ui.findMovies.composable.MoviesDisplay

@Composable
fun FindMovieScreen(onBack: () -> Unit, onMenu: () -> Unit) {
    val searchInput = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            FindMovieTopAppBar(
                contentText = stringResource(R.string.find_a_movie),
                navigationIcon = {
                    IconButton(onClick = onMenu) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = null
                        )
                    }
                },
                onSearchEvent = { search ->
                    searchInput.value = search
                }
            )
        },
        content = {
            val findMoviesViewModel = hiltViewModel<FindMoviesViewModel>()
            if (searchInput.value.isNotEmpty()) {
                findMoviesViewModel.findMoviesByName(searchInput.value)
            }
            FindMovieContent(
                findMoviesViewModel = findMoviesViewModel,
                paddingValues = it
            )
        }
    )
}

@Composable
private fun FindMovieContent(
    findMoviesViewModel: FindMoviesViewModel,
    paddingValues: PaddingValues
) {
    val uiState = findMoviesViewModel.uiState().collectAsState()
    when (val currentState = uiState.value) {
        DefaultUiState -> DefaultDisplay()
        is MoviesDisplayUiState -> MoviesDisplay(
            screenState = currentState.screenState,
            paddingValues = paddingValues
        )
        is ErrorUiState -> ErrorMessage(message = currentState.throwable.localizedMessage)
    }
}
