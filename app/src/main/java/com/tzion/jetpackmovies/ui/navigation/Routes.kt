package com.tzion.jetpackmovies.ui.navigation

sealed class Routes(val route: String) {
    object FindMovie : Routes(route = "findMovies")
    object MovieDetail : Routes(route = "movieDetail/{movieId}")
    object FavoriteMovie : Routes(route = "favoriteMovie")
}
