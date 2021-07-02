package com.tzion.jetpackmovies.data.mapper

import com.tzion.jetpackmovies.data.remote.model.RemoteMovie
import com.tzion.jetpackmovies.data.remote.model.RemoteSearch
import com.tzion.jetpackmovies.domain.model.DomainMovie
import javax.inject.Inject

class DataMovieMapper @Inject constructor() {

    fun RemoteSearch.fromRemoteToDomain(): List<DomainMovie> = search.map { remoteMovie ->
        remoteMovie.fromRemoteToDomain()
    }

    fun RemoteMovie.fromRemoteToDomain() = DomainMovie(
        movieId = imdbId,
        title = title,
        year = year,
        poster = poster,
        type = type
    )

}
