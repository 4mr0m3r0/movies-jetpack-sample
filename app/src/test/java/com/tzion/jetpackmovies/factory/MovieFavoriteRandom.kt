package com.tzion.jetpackmovies.factory

import com.tzion.jetpackmovies.data.model.DataFavoriteMovie

object MovieFavoriteRandom {
    fun generateDataFavorite() = DataFavoriteMovie(
        id = RandomFactory.generateString(),
        title = RandomFactory.generateString(),
        year = RandomFactory.generateString(),
        rated = RandomFactory.generateString(),
        released = RandomFactory.generateString(),
        runtime = RandomFactory.generateString(),
        genre = RandomFactory.generateString(),
        director = RandomFactory.generateString(),
        writer = RandomFactory.generateString(),
        actors = RandomFactory.generateString(),
        plot = RandomFactory.generateString(),
        language = RandomFactory.generateString(),
        country = RandomFactory.generateString(),
        awards = RandomFactory.generateString(),
        poster = RandomFactory.generateString(),
        metascore = RandomFactory.generateString(),
        rating = RandomFactory.generateString(),
        votes = RandomFactory.generateString(),
        type = RandomFactory.generateString(),
        dvd = RandomFactory.generateString(),
        boxOffice = RandomFactory.generateString(),
        production = RandomFactory.generateString(),
        website = RandomFactory.generateString()
    )
}