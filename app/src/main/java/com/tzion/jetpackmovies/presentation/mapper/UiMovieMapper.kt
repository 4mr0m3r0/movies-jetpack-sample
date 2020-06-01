package com.tzion.jetpackmovies.presentation.mapper

import com.tzion.jetpackmovies.presentation.model.UiMovie
import com.tzion.jetpackmovies.domain.model.DomainMovie
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