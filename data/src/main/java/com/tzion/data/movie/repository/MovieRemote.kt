package com.tzion.data.movie.repository

import com.tzion.data.movie.model.MovieEntity
import io.reactivex.Flowable

interface MovieRemote {

    fun getMovies(): Flowable<List<MovieEntity>>

}