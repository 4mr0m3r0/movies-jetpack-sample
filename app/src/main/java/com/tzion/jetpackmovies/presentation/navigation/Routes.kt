package com.tzion.jetpackmovies.presentation.navigation

typealias Destination = String
object Route {
    val findMovie: Destination = "findMovies"
    val movieDetail: Destination = "movieDetail/{movieId}"
    val favoriteMovie: Destination = "favoriteMovie"

    fun makeDetailDestinationWithParam(movieId: String) = "movieDetail/$movieId"
}