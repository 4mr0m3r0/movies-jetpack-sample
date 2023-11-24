package com.tzion.jetpackmovies.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tzion.jetpackmovies.ui.favoriteMovies.FavoriteMoviesScreen
import com.tzion.jetpackmovies.ui.findMovies.FindMovieScreen
import com.tzion.jetpackmovies.ui.movieDetail.MovieDetailScreen

@ExperimentalAnimationApi
fun NavGraphBuilder.findMovie(
    navActions: NavActions,
    onMenu: () -> Unit
) = composable(
    route = Routes.FindMovie.route,
    enterTransition = { enterTransition },
    exitTransition = { exitTransition },
    popEnterTransition = { popEnterTransition },
    popExitTransition = { popExitTransition }
) {
    FindMovieScreen(
        onBack = navActions.upPress,
        onMenu = onMenu
    )
}

@ExperimentalAnimationApi
fun NavGraphBuilder.movieDetail(navActions: NavActions) = composable(
    route = Routes.MovieDetail.route,
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
    route = Routes.FavoriteMovie.route,
    enterTransition = { enterTransition },
    exitTransition = { exitTransition },
    popEnterTransition = { popEnterTransition },
    popExitTransition = { popExitTransition }
) {
    FavoriteMoviesScreen()
}