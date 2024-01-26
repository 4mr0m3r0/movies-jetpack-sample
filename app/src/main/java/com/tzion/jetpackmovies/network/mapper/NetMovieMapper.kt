package com.tzion.jetpackmovies.network.mapper

import com.tzion.jetpackmovies.domain.model.DomainMovie
import com.tzion.jetpackmovies.network.model.RemoteMovie
import com.tzion.jetpackmovies.network.model.RemoteSearch
import javax.inject.Inject

class NetMovieMapper @Inject constructor() {

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
