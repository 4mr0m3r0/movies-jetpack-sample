package com.tzion.jetpackmovies.presentation.navigation

sealed class Destination(val route: String) {
    data object FindMovies : Destination("findMovies")
    data object MovieDetail : Destination("movieDetail/{${Name.MOVIE_ID}}") {
        fun routeWithIdArgument(movieId: String) = "movieDetail/$movieId"
    }
    data object FavoriteMovie : Destination("favoriteMovie")
    companion object Argument {
        object Name {
            const val MOVIE_ID = "movieId"
        }
    }
}