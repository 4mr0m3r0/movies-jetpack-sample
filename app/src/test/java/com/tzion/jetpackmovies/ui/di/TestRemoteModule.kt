package com.tzion.jetpackmovies.ui.di

import com.tzion.jetpackmovies.data.remote.Remote
import com.tzion.jetpackmovies.data.remote.retrofit.WebServiceRetrofit
import dagger.Module
import dagger.Provides
import io.mockk.mockk

@Module
object TestRemoteModule {

    @Provides
    @JvmStatic
    fun providesMovieRestApi(): WebServiceRetrofit {
        return mockk()
    }

    @Provides
    @JvmStatic
    fun providesMoviesRemote(): Remote {
        return mockk()
    }
}
