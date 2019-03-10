package com.tzion.openmoviesdatabase.movie.factory

import com.tzion.domain.movie.model.Movie
import com.tzion.openmoviesdatabase.factory.RandomFactory
import com.tzion.openmoviesdatabase.movie.model.MovieView

object MoviesFactory {

    fun makeMovieList(count: Int): List<Movie> {
        return (0..count).map { makeMovie() }
    }

    fun makeMovie(): Movie {
        return Movie(
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString()
        )
    }

    fun makeMovieViewList(count: Int): List<MovieView> {
        return (0..count).map { makeMovieView() }
    }

    fun makeMovieView(): MovieView {
        return MovieView(
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            "https://picsum.photos/200/300/?random",
            RandomFactory.generateString()
        )
    }

}