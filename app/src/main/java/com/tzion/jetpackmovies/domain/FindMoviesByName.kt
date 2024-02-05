package com.tzion.jetpackmovies.domain

import com.tzion.jetpackmovies.domain.gateway.NetworkGateway
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class FindMoviesByName(
    private val networkGateway: NetworkGateway,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    fun findMovieByName(name: String?) = flow {
        require(!name.isNullOrEmpty())
        val moviesFound = withContext(dispatcher) {
            networkGateway.findMoviesByName(name = name.trim())
        }
        emit(moviesFound)
    }
}
