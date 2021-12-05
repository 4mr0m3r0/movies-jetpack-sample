package com.tzion.jetpackmovies.ui.navigation

import androidx.navigation.NavHostController

class NavActions(navHostController: NavHostController) {
    val findMovieAction = {
        navHostController.navigate(route = Routes.FindMovie.route)
    }

    val movieDetailAction = {
        navHostController.navigate(route = Routes.MovieDetail.route)
    }

    val favoriteMovie = {
        navHostController.navigate(route = Routes.FavoriteMovie.route)
    }

    val upPress: () -> Unit = {
        navHostController.navigateUp()
    }
}
