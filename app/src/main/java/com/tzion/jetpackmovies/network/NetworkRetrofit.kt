package com.tzion.jetpackmovies.network

import com.tzion.jetpackmovies.domain.gateway.NetworkGateway
import com.tzion.jetpackmovies.domain.model.DomainMovie
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import com.tzion.jetpackmovies.network.mapper.NetMovieDetailMapper
import com.tzion.jetpackmovies.network.mapper.NetMovieMapper
import com.tzion.jetpackmovies.network.retrofit.WebServiceRetrofit
import javax.inject.Inject

class NetworkRetrofit @Inject constructor(
    private val webServiceRetrofit: WebServiceRetrofit,
    private val movieMapper: NetMovieMapper,
    private val detailMapper: NetMovieDetailMapper,
) : NetworkGateway {

    override suspend fun findMoviesByName(name: String): List<DomainMovie> {
        return with(movieMapper) {
            webServiceRetrofit.getMoviesByTitle(name).fromRemoteToDomain()
        }
    }

    override suspend fun getMovieDetailById(movieId: String): DomainMovieDetail {
        return with(detailMapper) {
            webServiceRetrofit.getMovieDetailById(movieId).fromRemoteToDomain()
        }
    }
}
