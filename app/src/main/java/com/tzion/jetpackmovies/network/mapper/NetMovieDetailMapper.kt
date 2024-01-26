package com.tzion.jetpackmovies.network.mapper

import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import com.tzion.jetpackmovies.network.model.RemoteMovieDetail
import javax.inject.Inject

class NetMovieDetailMapper @Inject constructor() {

    fun RemoteMovieDetail.fromRemoteToDomain() = DomainMovieDetail(
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
        poster = poster,
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
