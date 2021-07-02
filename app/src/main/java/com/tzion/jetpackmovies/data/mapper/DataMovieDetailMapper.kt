package com.tzion.jetpackmovies.data.mapper

import com.tzion.jetpackmovies.data.remote.model.RemoteMovieDetail
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import javax.inject.Inject

class DataMovieDetailMapper @Inject constructor() {

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
