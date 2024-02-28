package com.tzion.jetpackmovies.random

import com.tzion.jetpackmovies.domain.entities.Movie

object FavoriteMovieRandom {
    fun listOfFavoriteMovie(size: Int) = (0..<size).map {
        favoriteMovie()
    }

    fun favoriteMovie() = Movie.Favorite(
        movieId = RandomData.generateString(),
        title = RandomData.generateString(),
        year = RandomData.generateString(),
        genre = RandomData.generateString(),
        poster = "",
    )
}