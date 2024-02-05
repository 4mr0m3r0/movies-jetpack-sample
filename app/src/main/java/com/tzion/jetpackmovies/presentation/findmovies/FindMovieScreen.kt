package com.tzion.jetpackmovies.presentation.findmovies

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.findmovies.composable.DefaultDisplay
import com.tzion.jetpackmovies.presentation.findmovies.composable.ErrorMessage
import com.tzion.jetpackmovies.presentation.findmovies.composable.FindMovieTopAppBar
import com.tzion.jetpackmovies.presentation.findmovies.composable.MoviesDisplay
import com.tzion.jetpackmovies.presentation.findmovies.intenthandler.FindRequest

@Composable
fun FindMovieScreen(
    onBack: () -> Unit, onMenu: () -> Unit,
    viewModel: FindMoviesViewModel = hiltViewModel<FindMoviesViewModel>()
) {
    LaunchedEffect(true) {
        viewModel.intentHandler.handleRequest(
            request = FindRequest.EnterScreen,
            sendUserIntent = viewModel.sendUserIntent
        )
    }
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
                    viewModel.intentHandler.handleRequest(
                        request = FindRequest.SearchButton(query = querySearch),
                        sendUserIntent = viewModel.sendUserIntent
                    )
                }
            )
        },
        content = { paddingValues ->
            FindMovieContent(
                viewModel = viewModel,
                paddingValues = paddingValues,
            )
        }
    )
}

@Composable
private fun FindMovieContent(
    viewModel: FindMoviesViewModel,
    paddingValues: PaddingValues,
) {
    val uiState by viewModel.screenState.collectAsStateWithLifecycle()
    when  {
        uiState.isEmptyScreen -> DefaultDisplay()
        uiState.thereAreNoResults -> println("There are no results")
        uiState.errorMessage != null -> ErrorMessage(message = uiState.errorMessage)
        else -> MoviesDisplay(
            screenState = uiState,
            paddingValues = paddingValues,
            intentHandler = viewModel.intentHandler,
            sendUserIntent = viewModel.sendUserIntent,
        )
    }
}
