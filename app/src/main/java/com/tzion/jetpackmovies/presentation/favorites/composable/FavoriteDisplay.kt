package com.tzion.jetpackmovies.presentation.favorites.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.uicomponent.list.ListItemRow
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@Composable
fun FavoriteDisplay(movies: List<Movie.Favorite>) {
    LazyColumn(
        modifier = Modifier.testTag("FavColumn")
    ) {
        items(movies) { movie ->
            ListItemRow(
                title = movie.title,
                subtitle = movie.genre,
                extra = movie.year,
                image = movie.poster
            )
            Divider()
        }
    }
}

@Preview("Light")
@Composable
private fun Light() {
    MoviesTheme {
        Surface {
            FavoriteDisplay(
                movies = listOf(
                    Movie.Favorite(
                        movieId = "ID",
                        title = "Headline Content",
                        year = "Year",
                        genre = "Genre",
                        poster = "",
                    ),
                    Movie.Favorite(
                        movieId = "ID",
                        title = "Headline Content",
                        year = "Year",
                        genre = "Genre",
                        poster = "",
                    ),
                    Movie.Favorite(
                        movieId = "ID",
                        title = "Headline Content",
                        year = "Year",
                        genre = "Genre",
                        poster = "",
                    ),
                    Movie.Favorite(
                        movieId = "ID",
                        title = "Headline Content",
                        year = "Year",
                        genre = "Genre",
                        poster = "",
                    ),
                )
            )
        }
    }
}

@Preview("Dark")
@Composable
private fun Dark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            FavoriteDisplay(
                movies = listOf(
                    Movie.Favorite(
                        movieId = "ID",
                        title = "Headline Content",
                        year = "Year",
                        genre = "Genre",
                        poster = "",
                    ),
                    Movie.Favorite(
                        movieId = "ID",
                        title = "Headline Content",
                        year = "Year",
                        genre = "Genre",
                        poster = "",
                    ),
                    Movie.Favorite(
                        movieId = "ID",
                        title = "Headline Content",
                        year = "Year",
                        genre = "Genre",
                        poster = "",
                    ),
                    Movie.Favorite(
                        movieId = "ID",
                        title = "Headline Content",
                        year = "Year",
                        genre = "Genre",
                        poster = "",
                    ),
                )
            )
        }
    }
}
