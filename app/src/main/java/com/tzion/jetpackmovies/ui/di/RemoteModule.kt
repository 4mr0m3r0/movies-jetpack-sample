package com.tzion.jetpackmovies.ui.di

import com.tzion.jetpackmovies.common.EndpointConstantsHelper
import com.tzion.jetpackmovies.data.remote.Remote
import com.tzion.jetpackmovies.data.remote.RemoteImpl
import com.tzion.jetpackmovies.data.remote.factory.RetrofitWebServiceFactory
import com.tzion.jetpackmovies.data.remote.retrofit.WebServiceRetrofit
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class RemoteModule {

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

    @Binds
    abstract fun bindRemote(movieRemoteImpl: RemoteImpl): Remote
}
