package com.tzion.openmoviesdatabase.movie

import com.tzion.openmoviesdatabase.ViewMapper
import com.tzion.openmoviesdatabase.movie.model.MovieView
import com.tzion.presentation.movie.model.MoviePresentation
import javax.inject.Inject

class MovieViewMapper @Inject constructor(): ViewMapper<MoviePresentation, MovieView> {

    override fun mapToView(presentation: MoviePresentation): MovieView {
        return MovieView(presentation.movieId, presentation.title, presentation.year, presentation.poster, presentation.type)
    }

}