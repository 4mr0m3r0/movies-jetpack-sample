package com.tzion.jetpackmovies.factory

import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.presentation.model.ViewPoster

object MoviesFactory {

    fun randomPosters(count: Int): List<Movie.Poster> {
        return (0..count).map { randomPoster() }
    }

    fun randomPoster() = Movie.Poster(
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )

    fun makeMovieViewList(count: Int): List<ViewPoster> {
        return (0..count).map { makeMovieView() }
    }

    fun makeMovieView() = ViewPoster(
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        "https://picsum.photos/200/300/?random",
        RandomFactory.generateString()
    )
}
