package com.tzion.jetpackmovies.factory

import com.tzion.jetpackmovies.data.remote.model.RemoteMovieDetail
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail

object MovieDetailFactory {

    fun makeRemoteMovieDetail() = RemoteMovieDetail(
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )

    fun makeDomainMovieDetail() = DomainMovieDetail(
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString(),
        RandomFactory.generateString()
    )
}
