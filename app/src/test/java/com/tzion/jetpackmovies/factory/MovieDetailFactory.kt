package com.tzion.jetpackmovies.factory

import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.network.model.RemoteMovieDetail

object MovieDetailFactory {

    fun makeRemoteMovieDetail() = RemoteMovieDetail(
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
        ratings = emptyList(),
        metascore = RandomFactory.generateString(),
        imdbRating = RandomFactory.generateString(),
        imdbVotes = RandomFactory.generateString(),
        imdbId = RandomFactory.generateString(),
        type = RandomFactory.generateString(),
        dvd = RandomFactory.generateString(),
        boxOffice = RandomFactory.generateString(),
        production = RandomFactory.generateString(),
        website = RandomFactory.generateString(),
        response = RandomFactory.generateString()
    )

    fun randomMovieInformation() = Movie.Information(
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
        image = RandomFactory.generateString(),
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
