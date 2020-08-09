package com.tzion.jetpackmovies.ui.di.module

import com.tzion.jetpackmovies.common.EndpointConstantsHelper
import com.tzion.jetpackmovies.data.remote.RemoteImpl
import com.tzion.jetpackmovies.data.remote.factory.RetrofitWebServiceFactory
import com.tzion.jetpackmovies.data.remote.retrofit.WebServiceRetrofit
import com.tzion.jetpackmovies.data.remote.Remote
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RemoteModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideWebServiceRetrofit(): WebServiceRetrofit {
            return RetrofitWebServiceFactory<WebServiceRetrofit>().makeRemoteRestApi(
                isDebug = true,
                tClass = WebServiceRetrofit::class.java,
                baseUrl = EndpointConstantsHelper.REST_API_SERVER
            )
        }
    }

    @Binds
    abstract fun bindRemote(movieRemoteImpl: RemoteImpl): Remote
}