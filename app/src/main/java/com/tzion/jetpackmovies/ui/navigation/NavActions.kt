package com.tzion.jetpackmovies.ui.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

class NavActions(private val navHostController: NavHostController) {
    fun navigatingWithDrawer(routes: Routes) {
        navHostController.navigate(route = routes.route) {
            popUpTo(navHostController.graph.findStartDestination().id) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }
    val findMovie = {
        navHostController.navigate(route = Routes.FindMovie.route)
    }

    val movieDetail = {
        navHostController.navigate(route = Routes.MovieDetail.route)
    }

    val favoriteMovie = {
        navHostController.navigate(route = Routes.FavoriteMovie.route)
    }

    val upPress: () -> Unit = {
        navHostController.navigateUp()
    }
}
