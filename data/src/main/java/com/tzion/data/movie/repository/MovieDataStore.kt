package com.tzion.data.movie.repository

import com.tzion.data.movie.model.MovieEntity
import io.reactivex.Completable
import io.reactivex.Flowable

interface MovieDataStore {

    fun getMovies(): Flowable<List<MovieEntity>>

    fun saveMovies(clients: List<MovieEntity>): Completable

    fun clearMovies(): Completable

}