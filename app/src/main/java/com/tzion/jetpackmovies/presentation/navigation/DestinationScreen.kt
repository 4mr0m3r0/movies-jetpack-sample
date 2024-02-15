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
    route = Destination.FindMovies.route,
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
    route = Destination.MovieDetail.route,
//    arguments = listOf(navArgument(Argument.Name.MOVIE_ID) { type = NavType.StringType }),
    enterTransition = { enterTransition },
    exitTransition = { exitTransition },
    popEnterTransition = { popEnterTransition },
    popExitTransition = { popExitTransition }
) { backStackEntry ->
    MovieDetailScreen(
        onBack = navActions.upPress,
//        movieId = backStackEntry.arguments?.getString(Argument.Name.MOVIE_ID).orEmpty()
    )
}

@ExperimentalAnimationApi
fun NavGraphBuilder.favoriteMovie(navActions: NavActions) = composable(
    route = Destination.FavoriteMovie.route,
    enterTransition = { enterTransition },
    exitTransition = { exitTransition },
    popEnterTransition = { popEnterTransition },
    popExitTransition = { popExitTransition }
) {
    FavoriteMoviesScreen()
}