package com.tzion.jetpackmovies.domain

import com.tzion.jetpackmovies.domain.gateway.NetworkGateway
import com.tzion.jetpackmovies.domain.model.DomainMovie
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class FindMoviesByName(private val networkGateway: NetworkGateway) {

    private var movies = MutableSharedFlow<List<DomainMovie>>()
    val moviesOutput = movies.asSharedFlow()

    suspend fun findMovieByName(name: String?) {
        require(!name.isNullOrEmpty())
        val moviesFound = networkGateway.findMoviesByName(name)
        movies.emit(moviesFound)
    }
}
