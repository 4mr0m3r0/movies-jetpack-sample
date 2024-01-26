package com.tzion.jetpackmovies.network.retrofit

import com.tzion.jetpackmovies.network.config.WebServiceConfig.API_KEY
import com.tzion.jetpackmovies.network.config.WebServiceConfig.API_KEY_VALUE
import com.tzion.jetpackmovies.network.config.WebServiceConfig.ID_CRITERIA
import com.tzion.jetpackmovies.network.config.WebServiceConfig.PLOT_CRITERIA
import com.tzion.jetpackmovies.network.config.WebServiceConfig.PLOT_FULL
import com.tzion.jetpackmovies.network.config.WebServiceConfig.SEARCH_CRITERIA
import com.tzion.jetpackmovies.network.model.RemoteMovieDetail
import com.tzion.jetpackmovies.network.model.RemoteSearch
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServiceRetrofit {

    @GET("/")
    suspend fun getMoviesByTitle(
        @Query(SEARCH_CRITERIA) searchCriteria: String,
        @Query(API_KEY) apiKey: String = API_KEY_VALUE
    ): RemoteSearch

    @GET("/")
    suspend fun getMovieDetailById(
        @Query(ID_CRITERIA) movieId: String,
        @Query(PLOT_CRITERIA) plot: String = PLOT_FULL,
        @Query(API_KEY) apiKey: String = API_KEY_VALUE
    ): RemoteMovieDetail
}
