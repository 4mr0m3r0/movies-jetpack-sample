package com.tzion.jetpackmovies.ui.movieDetail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.MovieDetailViewModel
import com.tzion.jetpackmovies.presentation.uistates.MovieDetailUiState
import com.tzion.jetpackmovies.ui.movieDetail.composable.DetailDisplay
import com.tzion.jetpackmovies.ui.movieDetail.composable.DetailError
import com.tzion.jetpackmovies.ui.movieDetail.composable.DetailLoading
import com.tzion.jetpackmovies.ui.movieDetail.mapper.AttrsDetailMapper
import com.tzion.jetpackmovies.uicomponent.MovieTopAppBar
import com.tzion.jetpackmovies.uicomponent.NavigationArrowBack

@Composable
fun MovieDetailScreen(onBack: () -> Unit, movieId: String) {
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
            val mapper = AttrsDetailMapper(context = LocalContext.current)
            MovieDetailContent(
                mapper = mapper,
                movieId = movieId,
                paddingValues = paddingValues
            )
        }
    )
}

@Composable
private fun MovieDetailContent(
    mapper: AttrsDetailMapper,
    movieId: String,
    paddingValues: PaddingValues
) {
    val detailViewModel: MovieDetailViewModel = hiltViewModel()
    val uiState = detailViewModel.uiState().collectAsState()
    remember(movieId) {
        detailViewModel.loadMovieDetailById(movieId)
        true
    }
    when (val currentState = uiState.value) {
        MovieDetailUiState.Loading -> DetailLoading()
        is MovieDetailUiState.Display -> DetailDisplay(
            movieDetail = currentState.movieDetail,
            mapper = mapper,
            paddingValues = paddingValues,
        )
        MovieDetailUiState.Error -> DetailError()
    }
}
