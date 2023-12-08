package com.tzion.jetpackmovies.ui.movieDetail.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tzion.jetpackmovies.presentation.model.MovieDetail
import com.tzion.jetpackmovies.ui.movieDetail.mapper.AttrsDetailMapper
import com.tzion.jetpackmovies.uicomponent.template.MovieDetailTemplate

@Composable
fun DetailDisplay(
    movieDetail: MovieDetail,
    mapper: AttrsDetailMapper,
    paddingValues: PaddingValues
) {
    MovieDetailTemplate(
        attributes = with(mapper) { movieDetail.toAttributes() },
        modifier = Modifier.padding(top = paddingValues.calculateTopPadding())
    )
}
