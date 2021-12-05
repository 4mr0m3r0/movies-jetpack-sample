package com.tzion.jetpackmovies.presentation.mapper

import com.tzion.jetpackmovies.domain.model.DomainMovie
import com.tzion.jetpackmovies.presentation.model.Movie
import javax.inject.Inject

class UiMovieMapper @Inject constructor() {

    fun List<DomainMovie>.fromDomainToUi() = map { domainMovie ->
        domainMovie.fromDomainToUi()
    }

    fun DomainMovie.fromDomainToUi() = Movie(
        movieId = movieId ?: "",
        title = title ?: "",
        year = year ?: "",
        poster = poster ?: "",
        type = type ?: ""
    )
}
