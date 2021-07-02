package com.tzion.jetpackmovies.data.mapper

import com.tzion.jetpackmovies.data.cache.model.CacheFavoriteMovie
import com.tzion.jetpackmovies.domain.model.DomainFavoriteMovie
import javax.inject.Inject

class DataFavoriteMovieMapper @Inject constructor() {

    fun List<CacheFavoriteMovie>.fromCacheToDomain() = map { cacheFavoriteMovie ->
        cacheFavoriteMovie.fromCacheToDomain()
    }

    fun CacheFavoriteMovie.fromCacheToDomain() = DomainFavoriteMovie(
        movieId = id,
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
    fun DomainFavoriteMovie.fromDomainToCache() = CacheFavoriteMovie(
        id = movieId,
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

}
