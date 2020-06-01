package com.tzion.openmoviesdatabase.movies.presentation.mapper

import android.content.Context
import com.tzion.openmoviesdatabase.R
import com.tzion.openmoviesdatabase.helper.DefaultValues
import com.tzion.openmoviesdatabase.movies.domain.model.DomainMovieDetail
import com.tzion.openmoviesdatabase.movies.presentation.model.UiMovieDetail
import javax.inject.Inject

class UiMovieDetailMapper @Inject constructor(private val context: Context) {

    fun DomainMovieDetail.fromDomainToUi() = UiMovieDetail(
        title = title ?: DefaultValues.emptyString(),
        year = year ?: DefaultValues.emptyString(),
        released = "${context.getString(R.string.released)}: $released",
        runtime = "${context.getString(R.string.runtime)}: $runtime",
        genre = "${context.getString(R.string.genre)}: $genre",
        director = "${context.getString(R.string.director)}: $director",
        writer = "${context.getString(R.string.writer)}: $writer",
        actors = "${context.getString(R.string.actors)}: $actors",
        plot = plot ?: DefaultValues.emptyString(),
        language = "${context.getString(R.string.language)}: $language",
        country = "${context.getString(R.string.country)}: $country",
        awards = awards ?: DefaultValues.emptyString(),
        poster = poster ?: DefaultValues.emptyString(),
        imdbRating = "${context.getString(R.string.rating)}: $imdbRating",
        imdbVotes = "$imdbVotes ${context.getString(R.string.votes)}",
        type = type ?: DefaultValues.emptyString()
    )

}