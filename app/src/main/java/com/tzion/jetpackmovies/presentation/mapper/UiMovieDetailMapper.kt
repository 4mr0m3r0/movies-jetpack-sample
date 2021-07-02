package com.tzion.jetpackmovies.presentation.mapper

import com.tzion.jetpackmovies.domain.model.DomainFavoriteMovie
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import com.tzion.jetpackmovies.presentation.model.UiMovieDetail
import javax.inject.Inject

class UiMovieDetailMapper @Inject constructor() {

    fun DomainMovieDetail.fromDomainToUi() = UiMovieDetail(
        title = title.orEmpty(),
        year = year.orEmpty(),
        released = released.orEmpty(),
        runtime = runtime.orEmpty(),
        genre = genre.orEmpty(),
        director = director.orEmpty(),
        writer = writer.orEmpty(),
        actors = actors.orEmpty(),
        plot = plot.orEmpty(),
        language = language.orEmpty(),
        country = country.orEmpty(),
        awards = awards.orEmpty(),
        poster = poster.orEmpty(),
        rating = rating.orEmpty(),
        votes = votes.orEmpty(),
        type = type.orEmpty()
    )

    fun UiMovieDetail.fromUiMovieDetailToDomainFavoriteMovie(movieId: String) = DomainFavoriteMovie(
        movieId = movieId,
        title = title,
        year = year,
        rated = DefaultValues.emptyString(),
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
        metascore = "",
        rating = rating,
        votes = votes,
        type = type,
        dvd = "",
        boxOffice = "",
        production = "",
        website = ""
    )
}
