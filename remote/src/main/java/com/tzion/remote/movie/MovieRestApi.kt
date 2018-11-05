package com.tzion.remote.movie

import com.tzion.remote.movie.model.RemoteSearch
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Header

interface MovieRestApi {

    @GET("?apikey=e818df3e&s=Sicario")
    fun getMovies(): Flowable<RemoteSearch>

}