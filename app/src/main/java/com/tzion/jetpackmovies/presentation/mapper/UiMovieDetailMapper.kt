package com.tzion.jetpackmovies.presentation.mapper

import android.content.Context
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.domain.entities.TomatoMeter
import com.tzion.jetpackmovies.domain.entities.TomatoMeter.State.EMPTY
import com.tzion.jetpackmovies.domain.entities.TomatoMeter.State.FRESH
import com.tzion.jetpackmovies.domain.entities.TomatoMeter.State.ROTTEN
import com.tzion.jetpackmovies.uicomponent.template.AttrsDetailTemplate
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UiMovieDetailMapper @Inject constructor(@ApplicationContext val context: Context) {

    fun Movie.Information.toAttributes(): AttrsDetailTemplate {
        val (painterRes, descriptionRes) = getTomatoIconAndDescription(tomatoMeter)
        return AttrsDetailTemplate(
            title = title.orEmpty(),
            released = "${context.getString(R.string.released)}: $released",
            runtime = "${context.getString(R.string.runtime)}: $runtime",
            genre = "${context.getString(R.string.genre)}: $genre",
            director = "${context.getString(R.string.director)}: $director",
            writer = "${context.getString(R.string.writer)}: $writer",
            actors = "${context.getString(R.string.actors)}: $actors",
            plot = plot.orEmpty(),
            language = "${context.getString(R.string.language)}: $language",
            country = "${context.getString(R.string.country)}: $country",
            poster = image.orEmpty(),
            rating = "${context.getString(R.string.rating)}: $rating",
            votes = "$votes ${context.getString(R.string.votes)}",
            tomatoMeterPainter = painterRes,
            tomatoMeterContentDesc = context.getString(descriptionRes)
        )
    }

    private fun getTomatoIconAndDescription(
        tomatoMeterState: TomatoMeter.State?
    ): Pair<Int, Int> = when (tomatoMeterState) {
        FRESH -> R.drawable.tomatometer_fresh to R.string.red_tomato
        ROTTEN -> R.drawable.tomatometer_rotten to R.string.rotten_tomato
        EMPTY -> R.drawable.tomatometer_empty to R.string.empty_tomato
        else -> R.drawable.tomatometer_empty to R.string.empty_tomato
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

//    fun ViewMovieInfo.fromUiMovieDetailToDomainFavoriteMovie(movieId: String) = DomainFavoriteMovie(
//        movieId = movieId,
//        title = title,
//        year = year,
//        rated = "",
//        released = released,
//        runtime = runtime,
//        genre = genre,
//        director = director,
//        writer = writer,
//        actors = actors,
//        plot = plot,
//        language = language,
//        country = country,
//        awards = awards,
//        poster = poster,
//        metascore = "",
//        rating = rating,
//        votes = votes,
//        type = type,
//        dvd = "",
//        boxOffice = "",
//        production = "",
//        website = ""
//    )
}