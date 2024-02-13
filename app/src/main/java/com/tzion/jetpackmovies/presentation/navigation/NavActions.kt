package com.tzion.jetpackmovies.presentation.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

class NavActions(private val navHostController: NavHostController) {
    fun navigatingWithDrawer(route: Destination) {
        navHostController.navigate(route = route) {
            popUpTo(navHostController.graph.findStartDestination().id) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }
    val findMovie = {
        navHostController.navigate(route = Route.findMovie)
    }

    fun movieDetail(movieId: String) {
        navHostController.navigate(route = Route.makeDetailDestinationWithParam(movieId))
    }

    val favoriteMovie = {
        navHostController.navigate(route = Route.favoriteMovie)
    }

    val upPress: () -> Unit = {
        navHostController.navigateUp()
    }
}
