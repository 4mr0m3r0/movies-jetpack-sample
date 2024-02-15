package com.tzion.jetpackmovies.network.mapper

import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.network.model.RemoteMovieDetail
import javax.inject.Inject

class NetMovieInfoMapper @Inject constructor() {

    fun RemoteMovieDetail.toInformation() = Movie.Information(
        title = title,
        year = year,
        rated = rated,
        released = released,
        runtime = runtime,
        genre = genre,
        director = director,
        writer = writer,
        actors = actors,
        plot = plot,
        language = language,
        country = country,
        awards = awards,
        image = poster,
        metascore = metascore,
        rating = imdbRating,
        votes = imdbVotes,
        type = type,
        dvd = dvd,
        boxOffice = boxOffice,
        production = production,
        website = website
    )
}
