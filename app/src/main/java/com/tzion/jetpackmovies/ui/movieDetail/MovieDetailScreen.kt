package com.tzion.jetpackmovies.ui.movieDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
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
    val uiState = detailViewModel.uiState().collectAsState()
    UiStateRender(
        uiState = uiState.value,
        mapper = mapper
    )
    if (movieId.isNotEmpty()) {
        detailViewModel.loadMovieDetailById(movieId)
    } else {
        // TODO: show a message Error
    }
}
