package com.tzion.openmoviesdatabase.movies.factory

import com.tzion.openmoviesdatabase.factory.RandomFactory
import com.tzion.openmoviesdatabase.movies.domain.model.DomainMovie
import com.tzion.openmoviesdatabase.movies.presentation.model.UiMovie

object MoviesFactory {

    fun makeMovieList(count: Int): List<DomainMovie> {
        return (0..count).map { makeMovie() }
    }

    fun makeMovie() = DomainMovie(
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString())

    fun makeMovieViewList(count: Int): List<UiMovie> {
        return (0..count).map { makeMovieView() }
    }

    fun makeMovieView() =  UiMovie(
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            RandomFactory.generateString(),
            "https://picsum.photos/200/300/?random",
            RandomFactory.generateString())

}