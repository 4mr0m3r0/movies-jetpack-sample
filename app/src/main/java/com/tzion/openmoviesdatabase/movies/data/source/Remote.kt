package com.tzion.openmoviesdatabase.movies.data.source

import com.tzion.openmoviesdatabase.movies.data.remote.model.RemoteMovieDetail
import com.tzion.openmoviesdatabase.movies.data.remote.model.RemoteSearch
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface Remote {

    fun findMoviesByName(name: String): Flow<RemoteSearch>

    fun getMovieDetailById(movieId: String): Flow<RemoteMovieDetail>

}