package com.tzion.jetpackmovies.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.tzion.jetpackmovies.ui.findMovies.FindMovieScreen
import com.tzion.jetpackmovies.ui.movieDetail.MovieDetailScreen

@ExperimentalAnimationApi
@Composable
fun NavGraph(startDestination: String = Routes.FindMovie.route) {
    val navController = rememberAnimatedNavController()
    val navActions = remember(navController) { NavActions(navController) }
    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        findMovie(navActions)
        movieDetail(navActions)
        favoriteMovie(navActions)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.findMovie(navActions: NavActions) = composable(
    route = Routes.FindMovie.route,
    enterTransition = { enterTransition() },
    exitTransition = { exitTransition() },
    popEnterTransition = { popEnterTransition() },
    popExitTransition = { popExitTransition() }
) {
    FindMovieScreen(onBack = navActions.upPress)
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.movieDetail(navActions: NavActions) = composable(
    route = Routes.MovieDetail.route,
    enterTransition = { enterTransition() },
    exitTransition = { exitTransition() },
    popEnterTransition = { popEnterTransition() },
    popExitTransition = { popExitTransition() }
) { backStackEntry ->
    MovieDetailScreen(
        onBack = navActions.upPress,
        movieId = backStackEntry.arguments?.getString("movieId").orEmpty()
    )
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.favoriteMovie(navActions: NavActions) = composable(
    route = Routes.FavoriteMovie.route,
    enterTransition = { enterTransition() },
    exitTransition = { exitTransition() },
    popEnterTransition = { popEnterTransition() },
    popExitTransition = { popExitTransition() }
) {

}
