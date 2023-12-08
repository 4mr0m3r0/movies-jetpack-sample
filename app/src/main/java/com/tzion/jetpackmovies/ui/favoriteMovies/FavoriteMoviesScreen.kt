package com.tzion.jetpackmovies.ui.favoriteMovies

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.FavoriteMovieViewModel
import com.tzion.jetpackmovies.uicomponent.MovieTopAppBar
import com.tzion.jetpackmovies.uicomponent.NavigationArrowBack

@Composable
fun FavoriteMoviesScreen(onBack: () -> Unit = {}) {
    Scaffold(
        topBar = {
            MovieTopAppBar(
                text = stringResource(id = R.string.favorites_movies),
                navigationIcon = {
                    NavigationArrowBack(
                        navigationEvent = onBack,
                        contentDescription = stringResource(id = R.string.go_back)
                    )
                }
            )
        },
        content = {
            val favoriteMovieViewModel = hiltViewModel<FavoriteMovieViewModel>()
            FavoriteMoviesContent(
                favoriteMovieViewModel = favoriteMovieViewModel,
                paddingValues = it
            )
        }
    )
}

@Composable
private fun FavoriteMoviesContent(
    favoriteMovieViewModel: FavoriteMovieViewModel,
    paddingValues: PaddingValues
)  {

}