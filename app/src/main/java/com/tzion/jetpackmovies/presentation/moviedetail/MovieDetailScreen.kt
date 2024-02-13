package com.tzion.jetpackmovies.presentation.moviedetail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.mapper.ViewMovieDetailMapper
import com.tzion.jetpackmovies.presentation.moviedetail.composable.DetailDisplay
import com.tzion.jetpackmovies.presentation.moviedetail.composable.DetailError
import com.tzion.jetpackmovies.presentation.moviedetail.composable.DetailLoading
import com.tzion.jetpackmovies.presentation.uistates.MovieDetailUiState
import com.tzion.jetpackmovies.uicomponent.MovieTopAppBar
import com.tzion.jetpackmovies.uicomponent.NavigationArrowBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(
    onBack: () -> Unit, movieId: String,
    viewModel: MovieDetailViewModel = hiltViewModel<MovieDetailViewModel>()
) {
    Scaffold(
        topBar = {
            MovieTopAppBar(
                text = stringResource(id = R.string.detail),
                navigationIcon = {
                    NavigationArrowBack(
                        navigationEvent = onBack,
                        contentDescription = stringResource(id = R.string.detail)
                    )
                }
            )
        },
        content = { paddingValues ->
            val mapper = ViewMovieDetailMapper(context = LocalContext.current)
            MovieDetailContent(
                movieId = movieId,
                paddingValues = paddingValues,
                viewModel = viewModel
            )
        }
    )
}

@Composable
private fun MovieDetailContent(
    movieId: String,
    paddingValues: PaddingValues,
    viewModel: MovieDetailViewModel
) {
    val uiState = viewModel.uiState().collectAsState()
    remember(movieId) {
        viewModel.loadMovieDetailById(movieId)
        true
    }
    when (val currentState = uiState.value) {
        MovieDetailUiState.Loading -> DetailLoading()
        is MovieDetailUiState.Display -> DetailDisplay(
            attributes = currentState.attributes,
            paddingValues = paddingValues,
        )
        MovieDetailUiState.Error -> DetailError()
    }
}
