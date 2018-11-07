package com.tzion.remote.movie

import com.tzion.data.movie.model.MovieEntity
import com.tzion.data.movie.repository.MovieRemote
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

class MovieRemoteImpl @Inject constructor(
    private val restApi: MovieRestApi,
    private val mapper: MovieRemoteMapper)
    : MovieRemote {

    override fun findMoviesByText(text: String?): Single<List<MovieEntity>> {
        return restApi.getMovies(text).map { search ->
            search.search.map { mapper.mapFromRemote(it) }
        }
    }

}