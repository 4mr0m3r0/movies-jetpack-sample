package com.tzion.domain.movie

import com.tzion.domain.movie.model.Movie
import io.reactivex.Completable
import io.reactivex.Observable

interface MovieRepository {

    fun getMovies(): Observable<List<Movie>>

    fun getMoviesByName(name: String?): Observable<List<Movie>>

}