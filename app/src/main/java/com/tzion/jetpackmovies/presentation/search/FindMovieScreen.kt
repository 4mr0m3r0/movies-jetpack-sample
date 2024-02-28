package com.tzion.jetpackmovies.presentation.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.search.FindSideEffect.NavigateToDetail
import com.tzion.jetpackmovies.presentation.search.composable.DefaultDisplay
import com.tzion.jetpackmovies.presentation.search.composable.ErrorMessage
import com.tzion.jetpackmovies.presentation.search.composable.FindMovieTopAppBar
import com.tzion.jetpackmovies.presentation.search.composable.MoviesDisplay
import com.tzion.jetpackmovies.presentation.search.intenthandler.FindRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindMovieScreen(
    onMenu: () -> Unit,
    onTapDetail: (movieId: String) -> Unit = {},
    viewModel: FindMoviesViewModel = hiltViewModel<FindMoviesViewModel>()
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
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
                },
                scrollBehavior = scrollBehavior
            )
        },
        content = { paddingValues ->
            FindMovieContent(
                viewModel = viewModel,
                paddingValues = paddingValues,
                onTapDetail = onTapDetail
            )
        }
    )
}

@Composable
private fun FindMovieContent(
    viewModel: FindMoviesViewModel,
    paddingValues: PaddingValues,
    onTapDetail: (movieId: String) -> Unit = {}
) {
    val uiState by viewModel.screenState.collectAsStateWithLifecycle()
    when  {
        uiState.isEmptyScreen -> DefaultDisplay()
        uiState.thereAreNoResults -> println(">>> There are no results")
        uiState.errorMessage != null -> ErrorMessage(message = uiState.errorMessage)
        else -> MoviesDisplay(
            screenState = uiState,
            paddingValues = paddingValues,
            intentHandler = viewModel.intentHandler,
            sendUserIntent = viewModel.sendUserIntent,
        )
    }

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is NavigateToDetail -> onTapDetail(sideEffect.movieId)
            }
        }
    }
}
