package com.tzion.openmoviesdatabase.di

import com.nhaarman.mockito_kotlin.mock
import com.tzion.openmoviesdatabase.movies.data.remote.retrofit.WebServiceRetrofit
import com.tzion.openmoviesdatabase.movies.data.source.Remote
import dagger.Module
import dagger.Provides

@Module
object TestRemoteModule {

    @Provides
    @JvmStatic
    fun providesMovieRestApi(): WebServiceRetrofit {
        return mock()
    }

    @Provides
    @JvmStatic
    fun providesMoviesRemote(): Remote {
        return mock()
    }

}