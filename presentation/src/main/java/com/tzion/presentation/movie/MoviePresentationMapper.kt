package com.tzion.presentation.movie

import com.tzion.domain.movie.model.Movie
import com.tzion.presentation.PresentationMapper
import com.tzion.presentation.movie.model.MoviePresentation
import javax.inject.Inject

open class MoviePresentationMapper @Inject constructor(): PresentationMapper<MoviePresentation, Movie> {

    override fun mapToPresentation(domain: Movie): MoviePresentation {
        return MoviePresentation(domain.movieId, domain.title, domain.year, domain.poster, domain.type)
    }

    override fun mapFromPresentation(presentation: MoviePresentation): Movie {
        return Movie(presentation.movieId, presentation.title, presentation.year, presentation.poster, presentation.type)
    }

}