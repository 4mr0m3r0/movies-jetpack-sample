package com.tzion.data.movie

import com.tzion.data.movie.repository.MovieCache
import com.tzion.data.movie.store.MovieDataStoreFactory
import com.tzion.domain.movie.MovieRepository
import com.tzion.domain.movie.model.Movie
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class MovieDataRepository @Inject constructor(
    private val mapper: MovieMapper,
    private val cache: MovieCache,
    private val factory: MovieDataStoreFactory)
    : MovieRepository {

    override fun getMovies(): Observable<List<Movie>> {
        return Observable.zip(cache.areMoviesCached().toObservable(),
            cache.isMoviesCacheExpired().toObservable(),
            BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { areCached, isExpired ->
                Pair(areCached, isExpired)
            })
            .flatMap {
                factory.getDataStore(it.first, it.second).getMovies().toObservable()
                    .distinctUntilChanged()
            }
            .flatMap {clients ->
                factory.getCacheDataStore()
                    .saveMovies(clients)
                    .andThen(Observable.just(clients))

            }
            .map {
                it.map {
                    mapper.mapFromEntity(it)
                }
            }
    }

    override fun getMoviesByName(name: String?): Observable<List<Movie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}