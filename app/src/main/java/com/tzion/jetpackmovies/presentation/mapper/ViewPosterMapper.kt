package com.tzion.jetpackmovies.presentation.mapper

import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.presentation.model.ViewPoster
import javax.inject.Inject

class ViewPosterMapper @Inject constructor() {

    fun List<Movie.Poster>.toViewPoster() = map { domainMovie ->
        domainMovie.toViewPoster()
    }

    private fun Movie.Poster.toViewPoster() = ViewPoster(
        movieId = movieId,
        title = title,
        year = year,
        image = image,
        type = type,
    )
}
