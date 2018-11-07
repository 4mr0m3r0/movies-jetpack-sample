package com.tzion.domain.test

import com.tzion.domain.movie.model.Movie
import java.util.*

object MovieDataFactory {

    fun makeMovieList(count: Int): List<Movie> {
        val movies = mutableListOf<Movie>()
        repeat(count) {
            movies.add(makeMovie())
        }
        return movies
    }

    fun makeMovie(): Movie {
        return Movie(randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid())
    }

    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }
}