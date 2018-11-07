package com.tzion.remote.test.factory

import com.tzion.data.movie.model.MovieEntity
import com.tzion.remote.movie.model.RemoteMovie
import com.tzion.remote.movie.model.RemoteSearch


object MovieDataFactory {

    fun makeMovieResponse(): RemoteSearch {
        return RemoteSearch(makeListOfMovies())
    }

    fun makeListOfMovies(): List<RemoteMovie> {
        return listOf(makeMovie(), makeMovie())
    }

    fun makeMovie(): RemoteMovie {
        return RemoteMovie(DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
            DataFactory.randomUuid(), DataFactory.randomUuid())
    }

    fun makeMovieEntity(): MovieEntity{
        return MovieEntity(DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
            DataFactory.randomUuid(), DataFactory.randomUuid())
    }

}