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
import com.tzion.jetpackmovies.presentation.findmovies.FindUserIntent
import com.tzion.jetpackmovies.presentation.findmovies.FindUserInterface
import com.tzion.jetpackmovies.presentation.findmovies.intenthandler.FindIntentHandler
import com.tzion.jetpackmovies.presentation.findmovies.intenthandler.FindRequest
import com.tzion.jetpackmovies.uicomponent.card.MovieCard
import com.tzion.jetpackmovies.uicomponent.progress.TopLoading
import java.util.Locale

@Composable
fun MoviesDisplay(
    screenState: FindUserInterface,
    paddingValues: PaddingValues,
    intentHandler: FindIntentHandler,
    sendUserIntent: (userIntent: FindUserIntent) -> Unit,
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
                items(screenState.posters, key = { it.movieId }) { poster ->
                    MovieCard(
                        headline = poster.year,
                        supportingText = poster.type capitalizedAndConcatenatedWith poster.title,
                        contentDescription = poster.title,
                        image = poster.image,
                        modifier = Modifier.clickable {
                            intentHandler.handleRequest(
                                request =  FindRequest.TapCard(movieId = poster.movieId),
                                sendUserIntent = sendUserIntent
                            )
                        }
                    )
                }
            }
        )
    }
}

infix fun String.capitalizedAndConcatenatedWith(title: String): String = "${replaceFirstChar { 
    if (it.isLowerCase()) it.titlecase(Locale.ROOT)
    else it.toString()
}}: $title"
