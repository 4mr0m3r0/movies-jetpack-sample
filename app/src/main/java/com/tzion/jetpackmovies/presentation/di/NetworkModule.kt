package com.tzion.jetpackmovies.presentation.di

import com.tzion.jetpackmovies.common.EndpointConstantsHelper
import com.tzion.jetpackmovies.domain.gateway.NetworkGateway
import com.tzion.jetpackmovies.network.NetworkRetrofit
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
    fun bindNetworkGateway(networkRetrofit: NetworkRetrofit): NetworkGateway

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