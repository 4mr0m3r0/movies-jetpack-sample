package com.tzion.jetpackmovies.network

import com.tzion.jetpackmovies.domain.boundary.RemoteFacade
import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.domain.posters.pager.PagingInfo
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
    private val dispatcher: CoroutineDispatcher,
) : RemoteFacade {
    override val pageSize: Int
        get() = PAGE_SIZE

    override suspend fun findMoviePostersByName(name: String, page: Int): PagingInfo {
        val searchRemote = withContext(dispatcher) {
            webServiceRetrofit.getPostersByTitle(query = name, page = page)
        }
        return with(movieMapper) { searchRemote.toPagingInfo() }
    }

    override suspend fun getMovieDetailById(movieId: String): Movie.Information =
        with(detailMapper) {
            webServiceRetrofit.getMovieDetailById(movieId).toInformation()
        }

    companion object {
        const val PAGE_SIZE = 10
    }
}
