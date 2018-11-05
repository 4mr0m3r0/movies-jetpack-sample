package com.tzion.presentation.movie

import com.tzion.domain.movie.model.Movie
import com.tzion.presentation.PresentationMapper
import com.tzion.presentation.movie.model.MovieView
import javax.inject.Inject

open class MovieViewMapper @Inject constructor(): PresentationMapper<MovieView, Movie> {

    override fun mapToView(domain: Movie): MovieView {
        return MovieView(domain.movieId, domain.title, domain.year, domain.poster)
    }

    override fun mapFromView(view: MovieView): Movie {
        return Movie(view.movieId, view.title, view.year, view.poster)
    }

}