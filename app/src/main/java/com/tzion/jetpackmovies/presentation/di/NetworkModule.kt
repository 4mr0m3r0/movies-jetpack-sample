package com.tzion.jetpackmovies.presentation.di

import com.tzion.jetpackmovies.domain.boundary.RemoteFacade
import com.tzion.jetpackmovies.network.MovieNetwork
import com.tzion.jetpackmovies.network.config.WebServiceConfig
import com.tzion.jetpackmovies.network.factory.RetrofitWebServiceBuilder
import com.tzion.jetpackmovies.network.retrofit.WebServiceRetrofit
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {
    @Binds
    fun bindNetworkGateway(movieNetwork: MovieNetwork): RemoteFacade

    companion object {
        @Provides
        fun providesDispatcher(): CoroutineDispatcher = Dispatchers.IO

        @Provides
        fun provideWebServiceRetrofit(): WebServiceRetrofit {
            return RetrofitWebServiceBuilder<WebServiceRetrofit>().makeRemoteRestApi(
                isDebug = true,
                tClass = WebServiceRetrofit::class.java,
                baseUrl = WebServiceConfig.BASE_URL
            )
        }
    }
}