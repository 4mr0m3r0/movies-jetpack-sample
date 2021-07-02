package com.tzion.jetpackmovies.presentation.mapper

import com.tzion.jetpackmovies.domain.model.DomainFavoriteMovie
import com.tzion.jetpackmovies.presentation.model.UiFavoriteMovie
import javax.inject.Inject

class UiFavoriteMovieMapper @Inject constructor() {

    fun DomainFavoriteMovie.fromDomainToUi() = UiFavoriteMovie(
        movieId = movieId,
        title = title,
        year = year,
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
        rating = rating,
        votes = votes,
        type = type
    )
}
