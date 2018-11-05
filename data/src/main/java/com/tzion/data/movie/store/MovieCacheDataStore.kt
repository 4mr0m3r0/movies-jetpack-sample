package com.tzion.data.movie.store

import com.tzion.data.movie.model.MovieEntity
import com.tzion.data.movie.repository.MovieCache
import com.tzion.data.movie.repository.MovieDataStore
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class MovieCacheDataStore @Inject constructor(
    private val movieCache: MovieCache)
    : MovieDataStore {

    override fun getMovies(): Flowable<List<MovieEntity>> {
        return movieCache.getMovies()
    }

    override fun saveMovies(clients: List<MovieEntity>): Completable {
        return movieCache.saveMovies(clients).andThen(
            movieCache.setLastCacheTime(System.currentTimeMillis())
        )
    }

    override fun clearMovies(): Completable {
        return movieCache.clearMovies()
    }

}