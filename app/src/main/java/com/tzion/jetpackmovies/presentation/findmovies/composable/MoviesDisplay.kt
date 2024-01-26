package com.tzion.jetpackmovies.presentation.findmovies.composable

import androidx.compose.foundation.clickable
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
import androidx.navigation.NavHostController
import com.tzion.jetpackmovies.presentation.uistates.MovieScreenState
import com.tzion.jetpackmovies.uicomponent.MovieCard
import com.tzion.jetpackmovies.uicomponent.TopLoading
import java.util.Locale

@Composable
fun MoviesDisplay(
    screenState: MovieScreenState,
    paddingValues: PaddingValues,
    navController: NavHostController
) {
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
                        headline = movie.year,
                        supportingText = movie.type capitalizedAndConcatenatedWith movie.title,
                        contentDescription = movie.title,
                        image = movie.poster,
                        modifier = Modifier.clickable {
                            navController.navigate("movieDetail/${movie.movieId}")
                        }
                    )
                }
            }
        )
    }
}

private infix fun String.capitalizedAndConcatenatedWith(title: String): String = "${replaceFirstChar { 
    if (it.isLowerCase()) it.titlecase(Locale.ROOT)
    else it.toString()
}}: $title"