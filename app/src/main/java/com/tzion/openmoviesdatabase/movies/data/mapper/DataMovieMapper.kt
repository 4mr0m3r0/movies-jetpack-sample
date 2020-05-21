package com.tzion.openmoviesdatabase.movies.data.mapper

import com.tzion.openmoviesdatabase.movies.data.remote.model.RemoteMovie
import com.tzion.openmoviesdatabase.movies.data.remote.model.RemoteSearch
import com.tzion.openmoviesdatabase.movies.domain.model.DomainMovie
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