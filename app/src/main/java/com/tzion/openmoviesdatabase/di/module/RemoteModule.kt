package com.tzion.openmoviesdatabase.di.module

import com.tzion.openmoviesdatabase.helper.EndpointConstantsHelper
import com.tzion.openmoviesdatabase.movies.data.remote.RemoteImpl
import com.tzion.openmoviesdatabase.movies.data.remote.factory.RetrofitWebServiceFactory
import com.tzion.openmoviesdatabase.movies.data.remote.retrofit.WebServiceRetrofit
import com.tzion.openmoviesdatabase.movies.data.source.Remote
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