package com.tzion.jetpackmovies.presentation.di

import com.tzion.jetpackmovies.common.EndpointConstantsHelper
import com.tzion.jetpackmovies.domain.boundary.RemoteFacade
import com.tzion.jetpackmovies.network.MovieNetwork
import com.tzion.jetpackmovies.network.factory.RetrofitWebServiceFactory
import com.tzion.jetpackmovies.network.retrofit.WebServiceRetrofit
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {
    @Binds
    fun bindNetworkGateway(movieNetwork: MovieNetwork): RemoteFacade

    companion object {
        @Provides
        fun provideWebServiceRetrofit(): WebServiceRetrofit {
            return RetrofitWebServiceFactory<WebServiceRetrofit>().makeRemoteRestApi(
                isDebug = true,
                tClass = WebServiceRetrofit::class.java,
                baseUrl = EndpointConstantsHelper.REST_API_SERVER
            )
        }
    }
}