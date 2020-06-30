package com.tzion.jetpackmovies.presentation.mapper

import android.content.Context
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.common.DefaultValues
import com.tzion.jetpackmovies.domain.model.DomainFavoriteMovie
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import com.tzion.jetpackmovies.presentation.model.UiMovieDetail
import javax.inject.Inject

class UiMovieDetailMapper @Inject constructor() {

    fun DomainMovieDetail.fromDomainToUi() = UiMovieDetail(
        title = title ?: DefaultValues.emptyString(),
        year = year ?: DefaultValues.emptyString(),
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
        rating = rating ?: DefaultValues.emptyString(),
        votes = votes ?: DefaultValues.emptyString(),
        type = type ?: DefaultValues.emptyString()
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
        metascore = DefaultValues.emptyString(),
        rating = rating,
        votes = votes,
        type = type,
        dvd = DefaultValues.emptyString(),
        boxOffice = DefaultValues.emptyString(),
        production = DefaultValues.emptyString(),
        website = DefaultValues.emptyString()
    )

}