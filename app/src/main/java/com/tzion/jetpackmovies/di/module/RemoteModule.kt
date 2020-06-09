package com.tzion.jetpackmovies.di.module

import com.tzion.jetpackmovies.helper.EndpointConstantsHelper
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
                    true, WebServiceRetrofit::class.java, EndpointConstantsHelper.REST_API_SERVER
            )
        }
    }

    @Binds
    abstract fun bindRemote(movieRemoteImpl: RemoteImpl): Remote
}