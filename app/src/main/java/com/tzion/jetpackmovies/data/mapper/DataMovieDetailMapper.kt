package com.tzion.jetpackmovies.data.mapper

import com.tzion.jetpackmovies.data.cache.model.CacheMovieDetail
import com.tzion.jetpackmovies.data.remote.model.RemoteMovieDetail
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import com.tzion.jetpackmovies.common.DefaultValues
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

    fun List<CacheMovieDetail>.fromCacheToDomain() = map { cacheMovieDetail ->
        cacheMovieDetail.fromCacheToDomain()
    }

    fun CacheMovieDetail.fromCacheToDomain() = DomainMovieDetail(
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
        rating = rating,
        votes = votes,
        type = type,
        dvd = dvd,
        boxOffice = boxOffice,
        production = production,
        website = website
    )

    fun DomainMovieDetail.fromDomainToCache() = CacheMovieDetail(
        title = title ?: DefaultValues.emptyString(),
        year = year ?: DefaultValues.emptyString(),
        rated = rated ?: DefaultValues.emptyString(),
        released = released ?: DefaultValues.emptyString(),
        runtime = runtime ?: DefaultValues.emptyString(),
        genre = genre ?: DefaultValues.emptyString(),
        director = director ?: DefaultValues.emptyString(),
        writer = writer ?: DefaultValues.emptyString(),
        actors = actors ?: DefaultValues.emptyString(),
        plot = plot ?: DefaultValues.emptyString(),
        language = language ?: DefaultValues.emptyString(),
        country = country ?: DefaultValues.emptyString(),
        awards = awards ?: DefaultValues.emptyString(),
        poster = poster ?: DefaultValues.emptyString(),
        metascore = metascore ?: DefaultValues.emptyString(),
        rating = rating ?: DefaultValues.emptyString(),
        votes = votes ?: DefaultValues.emptyString(),
        type = type ?: DefaultValues.emptyString(),
        dvd = dvd ?: DefaultValues.emptyString(),
        boxOffice = boxOffice ?: DefaultValues.emptyString(),
        production = production ?: DefaultValues.emptyString(),
        website = website ?: DefaultValues.emptyString()
    )

}