package com.tzion.jetpackmovies.ui.movieDetail.mapper

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.model.MovieDetail
import com.tzion.jetpackmovies.uicomponent.template.AttrsDetailTemplate

class AttrsDetailMapper(private val context: Context) {

    @Composable
    fun MovieDetail.toAttributes(): AttrsDetailTemplate {
        val (painterRes, descriptionRes) = getTomatoIconAndDescription(tomatoMeter)
        return AttrsDetailTemplate(
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
            votes = "$votes ${context.getString(R.string.votes)}",
            tomatoMeterPainter = painterResource(id = painterRes),
            tomatoMeterContentDesc = stringResource(id = descriptionRes)
        )
    }
}

private fun getTomatoIconAndDescription(tomatoMeter: MovieDetail.TomatoMeter): Pair<Int, Int> = when (tomatoMeter) {
    MovieDetail.TomatoMeter.FRESH -> R.drawable.tomatometer_fresh to R.string.red_tomato
    MovieDetail.TomatoMeter.ROTTEN -> R.drawable.tomatometer_rotten to R.string.rotten_tomato
    MovieDetail.TomatoMeter.EMPTY -> R.drawable.tomatometer_empty to R.string.empty_tomato
}

/**
 * AttrsDetailTemplate(
 *             poster = movieDetail.poster,
 *             title = movieDetail.title,
 *             runtime = movieDetail.runtime,
 *             released = movieDetail.released,
 *             rating = movieDetail.rating,
 *             votes = movieDetail.votes,
 *             plot = movieDetail.plot,
 *             genre = movieDetail.genre,
 *             actors = movieDetail.actors,
 *             writer = movieDetail.writer,
 *             director = movieDetail.director,
 *             language = movieDetail.language,
 *             country = movieDetail.country,
 *             tomatoMeterPainter = painterResource(id = painter),
 *             tomatoMeterContentDesc = stringResource(id = description)
 *         )
 */