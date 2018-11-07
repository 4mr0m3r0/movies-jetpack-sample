package com.tzion.remote.movie

import com.tzion.remote.movie.model.RemoteSearch
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieRestApi {

    @GET("/")
    fun getMovies(@Query("s") searchCriteria: String?, @Query("apikey") apiKey: String = "e818df3e"): Single<RemoteSearch>

}