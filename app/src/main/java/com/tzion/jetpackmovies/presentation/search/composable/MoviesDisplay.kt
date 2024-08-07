package com.tzion.jetpackmovies.presentation.search.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.uicomponent.card.MovieCard
import com.tzion.jetpackmovies.uicomponent.progress.TopLoading
import java.util.Locale

@Composable
fun MoviesDisplay(
    posters: LazyPagingItems<Movie.Poster>,
    paddingValues: PaddingValues,
    onTapCard: (posterId: String) -> Unit = {},
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(
            start = 8.dp,
            top = paddingValues.calculateTopPadding(),
            end = 8.dp,
            bottom = paddingValues.calculateBottomPadding(),
        ).fillMaxSize()
    ) {
        if (posters.loadState.refresh == LoadState.Loading) {
            item {
                TopLoading(modifier = Modifier.fillMaxWidth())
            }
        }
        items(count = posters.itemCount) { index ->
            posters[index]?.let { poster ->
                MovieCard(
                    headline = poster.year,
                    supportingText = poster.type capitalizedAndConcatenatedWith poster.title,
                    contentDescription = poster.title,
                    image = poster.image,
                    modifier = Modifier.clickable { onTapCard(poster.movieId) }
                )
            }
        }
        if (posters.loadState.append == LoadState.Loading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

infix fun String.capitalizedAndConcatenatedWith(title: String): String = "${replaceFirstChar { 
    if (it.isLowerCase()) it.titlecase(Locale.ROOT)
    else it.toString()
}}: $title"
