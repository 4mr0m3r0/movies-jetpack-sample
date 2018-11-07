package com.tzion.presentation.test.factory

import com.tzion.domain.movie.model.Movie
import com.tzion.presentation.movie.model.MoviePresentation

object MovieFactory {

    fun makeMovieView(): MoviePresentation {
        return MoviePresentation(DataFactory.randomString(), DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString())
    }

    fun makeMovie(): Movie {
        return Movie(DataFactory.randomString(), DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString())
    }

    fun makeMovieViewList(count: Int): List<MoviePresentation> {
        val movies = mutableListOf<MoviePresentation>()
        repeat(count) {
            movies.add(makeMovieView())
        }
        return movies
    }

    fun makeMovieList(count: Int): List<Movie> {
        val movies = mutableListOf<Movie>()
        repeat(count) {
            movies.add(makeMovie())
        }
        return movies
    }

}