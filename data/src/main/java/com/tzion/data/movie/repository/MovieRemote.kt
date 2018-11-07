package com.tzion.data.movie.repository

import com.tzion.data.movie.model.MovieEntity
import io.reactivex.Flowable
import io.reactivex.Single

interface MovieRemote {

    fun findMoviesByText(text: String?): Single<List<MovieEntity>>

}