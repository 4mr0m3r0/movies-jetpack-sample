package com.tzion.jetpackmovies.presentation.favorites

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.presentation.favorites.composable.FavoriteDisplay
import com.tzion.jetpackmovies.uicomponent.appbar.MovieTopAppBar
import com.tzion.jetpackmovies.uicomponent.button.ArrowBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteMoviesScreen(onBack: () -> Unit = {}) {
    Scaffold(
        topBar = {
            MovieTopAppBar(
                text = stringResource(id = R.string.favorites_movies),
                navigationIcon = {
                    ArrowBack(
                        onClick = onBack,
                        contentDescription = stringResource(id = R.string.go_back)
                    )
                }
            )
        },
        content = {
//            val favoriteMovieViewModel = hiltViewModel<FavoriteMovieViewModel>()
            FavoriteMoviesContent(
//                favoriteMovieViewModel = favoriteMovieViewModel,
                paddingValues = it
            )
        }
    )
}

@Composable
private fun FavoriteMoviesContent(
//    favoriteMovieViewModel: FavoriteMovieViewModel,
    paddingValues: PaddingValues
)  {
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