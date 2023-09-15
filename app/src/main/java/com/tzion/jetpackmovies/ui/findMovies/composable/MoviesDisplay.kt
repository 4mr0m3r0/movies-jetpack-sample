package com.tzion.jetpackmovies.ui.findMovies.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tzion.jetpackmovies.presentation.uistates.MovieScreenState
import com.tzion.jetpackmovies.uicomponent.MovieCard
import com.tzion.jetpackmovies.uicomponent.TopLoading

@Composable
fun MoviesDisplay(screenState: MovieScreenState, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(
                start = 8.dp,
                top = paddingValues.calculateTopPadding(),
                end = 8.dp,
                bottom = paddingValues.calculateBottomPadding()
            )
            .fillMaxSize()
    ) {
        if (screenState.isLoading) {
            TopLoading(modifier = Modifier.fillMaxWidth())
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(screenState.movies) { movie ->
                    MovieCard(
                        headline = movie.title,
                        supportingText = "${movie.type} ${movie.year}",
                        contentDescription = movie.title,
                        image = movie.poster
                    )
                }
            }
        )
    }
}
