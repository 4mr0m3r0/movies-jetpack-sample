package com.tzion.cache.movie

import com.tzion.cache.CacheDatabase
import com.tzion.cache.config.model.Config
import com.tzion.data.movie.model.MovieEntity
import com.tzion.data.movie.repository.MovieCache
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class MovieCacheImpl @Inject constructor(
    private val cacheDatabase: CacheDatabase,
    private val mapper: CachedMovieMapper)
    :MovieCache {

    override fun clearMovies(): Completable {
        return Completable.defer {
            cacheDatabase.cachedMovieDao().deleteMovies()
            Completable.complete()
        }
    }

    override fun saveMovies(clients: List<MovieEntity>): Completable {
        return Completable.defer {
            cacheDatabase.cachedMovieDao().insertMovies(
                clients.map { mapper.mapToCached(it) })
            Completable.complete()

        }
    }

    override fun getMovies(): Flowable<List<MovieEntity>> {
        return cacheDatabase.cachedMovieDao().getMovies().
            map {
                it.map { mapper.mapFromCached(it)
                }
            }
    }

    override fun areMoviesCached(): Single<Boolean> {
        return cacheDatabase.cachedMovieDao().getMovies().isEmpty
            .map {
                !it
            }
    }

    override fun setLastCacheTime(lastCache: Long): Completable {
        return Completable.defer {
            cacheDatabase.configDao().insertConfig(Config(lastCacheTime = lastCache))
            Completable.complete()
        }
    }

    override fun isMoviesCacheExpired(): Single<Boolean> {
        val currentTime = System.currentTimeMillis()
        val expirationTime = (60 * 10 * 1000).toLong()
        return cacheDatabase.configDao().getConfig()
            .onErrorReturn { Config(lastCacheTime = 0) }
            .map {
                currentTime - it.lastCacheTime > expirationTime
            }
    }

}