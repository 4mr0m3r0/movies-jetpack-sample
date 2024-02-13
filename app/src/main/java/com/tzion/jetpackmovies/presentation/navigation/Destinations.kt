package com.tzion.jetpackmovies.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tzion.jetpackmovies.presentation.findmovies.FindMovieScreen
import com.tzion.jetpackmovies.presentation.moviedetail.MovieDetailScreen
import com.tzion.jetpackmovies.ui.favoriteMovies.FavoriteMoviesScreen

@ExperimentalAnimationApi
fun NavGraphBuilder.findMovie(
    onMenu: () -> Unit,
    navActions: NavActions
) = composable(
    route = Route.findMovie,
    enterTransition = { enterTransition },
    exitTransition = { exitTransition },
    popEnterTransition = { popEnterTransition },
    popExitTransition = { popExitTransition }
) {
    FindMovieScreen(
        onMenu = onMenu,
        onTapDetail = { navActions.movieDetail(movieId = it) }
    )
}

@ExperimentalAnimationApi
fun NavGraphBuilder.movieDetail(navActions: NavActions) = composable(
    route = Route.movieDetail,
    enterTransition = { enterTransition },
    exitTransition = { exitTransition },
    popEnterTransition = { popEnterTransition },
    popExitTransition = { popExitTransition }
) { backStackEntry ->
    MovieDetailScreen(
        onBack = navActions.upPress,
        movieId = backStackEntry.arguments?.getString("movieId").orEmpty()
    )
}

@ExperimentalAnimationApi
fun NavGraphBuilder.favoriteMovie(navActions: NavActions) = composable(
    route = Route.favoriteMovie,
    enterTransition = { enterTransition },
    exitTransition = { exitTransition },
    popEnterTransition = { popEnterTransition },
    popExitTransition = { popExitTransition }
) {
    FavoriteMoviesScreen()
}