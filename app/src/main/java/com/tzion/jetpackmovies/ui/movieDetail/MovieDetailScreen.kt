package com.tzion.jetpackmovies.ui.movieDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.MovieDetailViewModel
import com.tzion.jetpackmovies.ui.movieDetail.mapper.AttrsDetailMapper
import com.tzion.jetpackmovies.uicomponent.MovieTopAppBar

@Composable
fun MovieDetailScreen(onBack: () -> Unit, movieId: String) {
    val context = LocalContext.current
    Column {
        MovieTopAppBar(
            contentText = stringResource(R.string.detail),
            navigationEvent = onBack
        )
        val detailViewModel: MovieDetailViewModel = viewModel()
        val mapper = AttrsDetailMapper(context)
        println(">>> New Mapper: $mapper")
        MovieDetailContent(
            detailViewModel = detailViewModel,
            mapper = mapper,
            movieId = movieId
        )
    }
}

@Composable
private fun MovieDetailContent(
    detailViewModel: MovieDetailViewModel,
    mapper: AttrsDetailMapper,
    movieId: String
) {
    val liveDataState = detailViewModel.getLiveData().observeAsState()
    liveDataState.value?.let { uiState ->
        UiStateRender(
            uiState = uiState,
            mapper = mapper
        )
    }
    if (movieId.isNotEmpty()) {
        detailViewModel.loadMovieDetailById(movieId)
    } else {
        // TODO: show a message Error
    }
}
