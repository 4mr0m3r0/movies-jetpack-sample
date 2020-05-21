package com.tzion.openmoviesdatabase.di

import com.nhaarman.mockito_kotlin.mock
import com.tzion.data.movie.repository.MovieRemote
import com.tzion.remote.movie.MovieRestApi
import dagger.Module
import dagger.Provides

@Module
object TestRemoteModule {

    @Provides
    @JvmStatic
    fun providesMovieRestApi(): MovieRestApi {
        return mock()
    }

    @Provides
    @JvmStatic
    fun providesMoviesRemote(): MovieRemote {
        return mock()
    }

}