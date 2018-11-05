package com.tzion.data.movie

import com.tzion.data.EntityMapper
import com.tzion.data.movie.model.MovieEntity
import com.tzion.domain.movie.model.Movie
import javax.inject.Inject

class MovieMapper @Inject constructor(): EntityMapper<MovieEntity, Movie> {

    override fun mapFromEntity(entity: MovieEntity): Movie {
        return Movie(entity.imdbID, entity.title, entity.year, entity.poster)
    }

    override fun mapToEntity(domain: Movie): MovieEntity {
        return MovieEntity(domain.movieId, domain.title, domain.year, domain.poster)
    }


}