package com.tzion.data.movie.store

import com.tzion.data.movie.repository.MovieDataStore
import javax.inject.Inject

class MovieDataStoreFactory @Inject constructor(
    private val movieCacheDataStore: MovieCacheDataStore,
    private val movieRemoteDataStore: MovieRemoteDataStore) {

    open fun getDataStore(moviesCached: Boolean, cacheExpired: Boolean): MovieDataStore {
        return if (moviesCached && !cacheExpired) {
            movieCacheDataStore
        } else {
            movieRemoteDataStore
        }
    }

    open fun getCacheDataStore(): MovieDataStore {
        return movieCacheDataStore
    }

}