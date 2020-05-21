package com.tzion.openmoviesdatabase.movies.presentation.mapper

import com.tzion.openmoviesdatabase.movies.presentation.model.UiMovie
import com.tzion.openmoviesdatabase.movies.domain.model.DomainMovie
import javax.inject.Inject

class UiMovieMapper @Inject constructor() {

    fun List<DomainMovie>.fromDomainToUi() = map { domainMovie ->
        domainMovie.fromDomainToUi()
    }

    fun DomainMovie.fromDomainToUi() = UiMovie(
        movieId = movieId ?: "",
        title = title ?: "",
        year = year ?: "",
        poster = poster ?: "",
        type = type ?: ""
    )

}