package com.tzion.jetpackmovies.ui.navigation

sealed class Routes(val route: String) {
    data object FindMovie : Routes(route = "findMovies")
    data object MovieDetail : Routes(route = "movieDetail/{movieId}")
    data object FavoriteMovie : Routes(route = "favoriteMovie")
}
