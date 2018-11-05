package com.tzion.remote.movie

import com.tzion.data.movie.model.MovieEntity
import com.tzion.data.movie.repository.MovieRemote
import io.reactivex.Flowable
import javax.inject.Inject

class MovieRemoteImpl @Inject constructor(
    private val restApi: MovieRestApi,
    private val mapper: MovieRemoteMapper)
    : MovieRemote {

    override fun getMovies(): Flowable<List<MovieEntity>> {
        return restApi.getMovies().map { search ->
            search.search.map { mapper.mapFromRemote(it) }
        }
    }

}