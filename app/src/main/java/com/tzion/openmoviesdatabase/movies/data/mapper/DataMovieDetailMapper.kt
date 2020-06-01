package com.tzion.openmoviesdatabase.movies.data.mapper

import com.tzion.openmoviesdatabase.movies.data.remote.model.RemoteMovieDetail
import com.tzion.openmoviesdatabase.movies.domain.model.DomainMovieDetail
import javax.inject.Inject

class DataMovieDetailMapper @Inject constructor(private val dataRatingMapper: DataRatingMapper) {

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
        ratings = with(dataRatingMapper) { ratings?.fromRemoteToDomain() },
        metascore = metascore,
        imdbRating = imdbRating,
        imdbVotes = imdbVotes,
        imdbId = imdbId,
        type = type,
        dvd = dvd,
        boxOffice = boxOffice,
        production = production,
        website = website
    )

}