package com.tzion.jetpackmovies.presentation.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

class NavActions(private val navHostController: NavHostController) {
    fun navigatingWithDrawer(destination: Destination) {
        navHostController.navigate(route = destination.route) {
            popUpTo(navHostController.graph.findStartDestination().id) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }
    val findMovie = {
        navHostController.navigate(route = Destination.FindMovies.route)
    }

    fun goToMovieDetail(movieId: String) {
        navHostController.navigate(route = Destination.MovieDetail.routeWithIdArgument(movieId))
    }

    val favoriteMovie = {
        navHostController.navigate(route = Destination.FavoriteMovie.route)
    }

    val upPress: () -> Unit = {
        navHostController.navigateUp()
    }
}
