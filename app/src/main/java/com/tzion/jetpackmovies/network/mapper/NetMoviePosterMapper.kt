package com.tzion.jetpackmovies.network.mapper

import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.network.model.RemoteMovie
import com.tzion.jetpackmovies.network.model.RemoteSearch
import javax.inject.Inject

class NetMoviePosterMapper @Inject constructor() {

    fun RemoteSearch.toPosters(): List<Movie.Poster> = search.map { remoteMovie ->
        remoteMovie.toPoster()
    }

    private fun RemoteMovie.toPoster() = Movie.Poster(
        movieId = imdbId,
        title = title.orEmpty(),
        year = year.orEmpty(),
        image = poster,
        type = type
    )
}
