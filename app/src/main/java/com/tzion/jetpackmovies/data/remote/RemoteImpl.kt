package com.tzion.jetpackmovies.data.remote

import com.tzion.jetpackmovies.data.remote.model.RemoteMovieDetail
import com.tzion.jetpackmovies.data.remote.model.RemoteSearch
import com.tzion.jetpackmovies.data.remote.retrofit.WebServiceRetrofit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteImpl @Inject constructor(
    private val webServiceRetrofit: WebServiceRetrofit): Remote {

    override fun findMoviesByName(name: String): Flow<RemoteSearch> = flow {
        emit(webServiceRetrofit.getMoviesByTitle(name))
    }

    override fun getMovieDetailById(movieId: String): Flow<RemoteMovieDetail> = flow {
        emit(webServiceRetrofit.getMovieDetailById(movieId))
    }

}