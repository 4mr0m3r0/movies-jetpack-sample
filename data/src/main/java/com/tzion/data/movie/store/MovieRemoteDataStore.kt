package com.tzion.data.movie.store

import com.tzion.data.movie.model.MovieEntity
import com.tzion.data.movie.repository.MovieDataStore
import com.tzion.data.movie.repository.MovieRemote
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class MovieRemoteDataStore @Inject constructor(
    private val movieRemote: MovieRemote)
    : MovieDataStore {

    override fun getMovies(): Flowable<List<MovieEntity>> {
        return movieRemote.getMovies()
    }

    override fun saveMovies(clients: List<MovieEntity>): Completable {
        throw UnsupportedOperationException("Saving clients isn't supported here...")
    }

    override fun clearMovies(): Completable {
        throw UnsupportedOperationException("Clear clients isn't supported here...")
    }

}