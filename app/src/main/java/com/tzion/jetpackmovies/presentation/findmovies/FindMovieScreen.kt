package com.tzion.jetpackmovies.presentation.findmovies

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
import androidx.navigation.NavHostController
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.findmovies.composable.DefaultDisplay
import com.tzion.jetpackmovies.presentation.findmovies.composable.ErrorMessage
import com.tzion.jetpackmovies.presentation.findmovies.composable.FindMovieTopAppBar
import com.tzion.jetpackmovies.presentation.findmovies.composable.MoviesDisplay
import com.tzion.jetpackmovies.presentation.findmovies.handler.FindIntentHandler
import com.tzion.jetpackmovies.presentation.findmovies.handler.FindIntentRequest
import com.tzion.jetpackmovies.presentation.findmovies.handler.FindIntentRequest.PressingSearchKeyboard
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState.DefaultUiState
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState.ErrorUiState
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState.MoviesDisplayUiState

@Composable
fun FindMovieScreen(
    onBack: () -> Unit, onMenu: () -> Unit,
    navController: NavHostController,
    intentHandler: FindIntentHandler,
    viewModel: FindMoviesStateHolder = hiltViewModel()
) {
    val searchInput = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            FindMovieTopAppBar(
                text = stringResource(R.string.find_a_movie),
                navigationIcon = {
                    IconButton(onClick = onMenu) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = null
                        )
                    }
                },
                onSearchEvent = { querySearch ->
                    searchInput.value = querySearch
                    intentHandler.handleRequest(
                        FindIntentRequest.PressingSearchButton(
                            query = querySearch,
                            viewModel = viewModel
                        )
                    )
                }
            )
        },
        content = { paddingValues ->
            if (searchInput.value.isNotEmpty()) {
                intentHandler.handleRequest(
                    PressingSearchKeyboard(
                        query = searchInput.value,
                        viewModel = viewModel
                    )
                )
            }
            FindMovieContent(
                viewModel = viewModel,
                paddingValues = paddingValues,
                navController = navController
            )
        }
    )
}

@Composable
private fun FindMovieContent(
    viewModel: FindMoviesStateHolder,
    paddingValues: PaddingValues,
    navController: NavHostController
) {
    val uiState = viewModel.uiState().collectAsState()
    when (val currentState = uiState.value) {
        DefaultUiState -> DefaultDisplay()
        is MoviesDisplayUiState -> MoviesDisplay(
            screenState = currentState.screenState,
            paddingValues = paddingValues,
            navController = navController
        )
        is ErrorUiState -> ErrorMessage(message = currentState.throwable.localizedMessage)
    }
}
