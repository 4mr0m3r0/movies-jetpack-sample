package com.tzion.jetpackmovies.ui.mapper

import android.content.Context
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.model.UiMovieDetail
import com.tzion.jetpackmovies.uicomponent.template.model.AttrsDetailTemplate
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class AttrsMapper @Inject constructor(@ActivityContext private val context: Context) {

    fun UiMovieDetail.fromUiToAttrs() = AttrsDetailTemplate(
        title = title,
        released = "${context.getString(R.string.released)}: $released",
        runtime = "${context.getString(R.string.runtime)}: $runtime",
        genre = "${context.getString(R.string.genre)}: $genre",
        director = "${context.getString(R.string.director)}: $director",
        writer = "${context.getString(R.string.writer)}: $writer",
        actors = "${context.getString(R.string.actors)}: $actors",
        plot = plot,
        language = "${context.getString(R.string.language)}: $language",
        country = "${context.getString(R.string.country)}: $country",
        poster = poster,
        rating = "${context.getString(R.string.rating)}: $rating",
        votes = "$votes ${context.getString(R.string.votes)}"
    )

}