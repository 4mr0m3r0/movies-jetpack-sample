package com.tzion.data.movie.repository

import com.tzion.data.movie.model.MovieEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface MovieCache {

    fun clearMovies(): Completable

    fun saveMovies(clients: List<MovieEntity>): Completable

    fun getMovies(): Flowable<List<MovieEntity>>

    fun areMoviesCached(): Single<Boolean>

    fun setLastCacheTime(lastCache: Long): Completable

    fun isMoviesCacheExpired(): Single<Boolean>

}