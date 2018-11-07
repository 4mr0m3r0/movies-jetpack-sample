package com.tzion.data.movie

import com.tzion.data.movie.repository.MovieCache
import com.tzion.data.movie.store.MovieDataStoreFactory
import com.tzion.domain.movie.MovieRepository
import com.tzion.domain.movie.model.Movie
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class MovieDataRepository @Inject constructor(
    private val mapper: MovieMapper,
    private val cache: MovieCache,
    private val factory: MovieDataStoreFactory)
    : MovieRepository {

    override fun findMoviesByText(text: String?): Single<List<Movie>> {
        return factory.getRemoteDataStore().findMoviesByText(text).map {
            it.map {
                mapper.mapFromEntity(it)
            }
        }

    }

}