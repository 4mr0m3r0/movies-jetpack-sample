package com.tzion.jetpackmovies.ui.di

import com.nhaarman.mockito_kotlin.mock
import com.tzion.jetpackmovies.data.remote.Remote
import com.tzion.jetpackmovies.data.remote.retrofit.WebServiceRetrofit
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
