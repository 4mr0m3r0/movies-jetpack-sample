package com.tzion.jetpackmovies.data.mapper

import com.tzion.jetpackmovies.data.model.DataFavoriteMovie
import com.tzion.jetpackmovies.domain.entities.Movie
import javax.inject.Inject

class DataFavoriteMapper @Inject constructor() {

    fun DataFavoriteMovie.toFavorite() = Movie.Favorite(
        movieId = id,
        title = title,
        year = year,
        rated = rated,
        released = released,
        runtime = runtime,
        genre = genre,
        director = director,
        writer = writer,
        actors = actors,
        plot = plot,
        language = language,
        country = country,
        awards = awards,
        poster = poster,
        metascore = metascore,
        rating = rating,
        votes = votes,
        type = type,
        dvd = dvd,
        boxOffice = boxOffice,
        production = production,
        website = website
    )

    fun Movie.Favorite.toData() = DataFavoriteMovie(
        id = movieId,
        title = title,
        year = year,
        rated = rated,
        released = released,
        runtime = runtime,
        genre = genre,
        director = director,
        writer = writer,
        actors = actors,
        plot = plot,
        language = language,
        country = country,
        awards = awards,
        poster = poster,
        metascore = metascore,
        rating = rating,
        votes = votes,
        type = type,
        dvd = dvd,
        boxOffice = boxOffice,
        production = production,
        website = website
    )
}
