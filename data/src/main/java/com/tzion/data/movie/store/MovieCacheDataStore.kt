package com.tzion.data.movie.store

import com.tzion.data.movie.model.MovieEntity
import com.tzion.data.movie.repository.MovieCache
import com.tzion.data.movie.repository.MovieDataStore
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class MovieCacheDataStore @Inject constructor(
    private val movieCache: MovieCache)
    : MovieDataStore {

    override fun findMoviesByText(text: String?): Single<List<MovieEntity>> {
        return movieCache.findMoviesByText(text)
    }

}