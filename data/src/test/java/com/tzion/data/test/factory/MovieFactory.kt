package com.tzion.data.test.factory

import com.segtechcu.data.test.factory.DataFactory
import com.tzion.data.movie.model.MovieEntity
import com.tzion.domain.movie.model.Movie

object MovieFactory {

    fun makeMovieEntity(): MovieEntity{
        return MovieEntity(
            DataFactory.randomString(), DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString())
    }

    fun makeMovie(): Movie {
        return Movie(DataFactory.randomString(), DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString())
    }

}