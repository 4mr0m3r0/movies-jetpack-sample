package com.tzion.remote.movie

import com.tzion.data.movie.model.MovieEntity
import com.tzion.remote.RemoteMapper
import com.tzion.remote.movie.model.RemoteMovie
import javax.inject.Inject

open class MovieRemoteMapper @Inject constructor(): RemoteMapper<RemoteMovie, MovieEntity> {

    override fun mapFromRemote(remote: RemoteMovie): MovieEntity {
        return MovieEntity(remote.imdbId, remote.title, remote.year, remote.poster, remote.type)
    }

}