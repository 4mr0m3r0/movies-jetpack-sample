package com.tzion.jetpackmovies.network

import com.tzion.jetpackmovies.domain.boundary.RemoteFacade
import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.network.mapper.NetMovieInfoMapper
import com.tzion.jetpackmovies.network.mapper.NetMoviePosterMapper
import com.tzion.jetpackmovies.network.retrofit.WebServiceRetrofit
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieNetwork @Inject constructor(
    private val webServiceRetrofit: WebServiceRetrofit,
    private val movieMapper: NetMoviePosterMapper,
    private val detailMapper: NetMovieInfoMapper,
    private val dispatcher: CoroutineDispatcher
) : RemoteFacade {

    override suspend fun findMoviePostersByName(name: String): List<Movie.Poster> {
        val searchRemote = withContext(dispatcher) {
            webServiceRetrofit.getMoviesByTitle(name)
        }
        return with(movieMapper) { searchRemote.toPosters() }
    }


    override suspend fun getMovieDetailById(movieId: String): Movie.Information =
        with(detailMapper) {
            webServiceRetrofit.getMovieDetailById(movieId).toInformation()
        }
}
