package com.tzion.jetpackmovies.data.remote

import com.tzion.jetpackmovies.data.remote.model.RemoteMovieDetail
import com.tzion.jetpackmovies.data.remote.model.RemoteSearch
import kotlinx.coroutines.flow.Flow

interface Remote {

    fun findMoviesByName(name: String): Flow<RemoteSearch>

    fun getMovieDetailById(movieId: String): Flow<RemoteMovieDetail>

}
