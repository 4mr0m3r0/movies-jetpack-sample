package com.tzion.openmoviesdatabase.di

import android.app.Application
import com.nhaarman.mockito_kotlin.mock
import com.tzion.cache.CacheDatabase
import com.tzion.data.movie.repository.MovieCache
import dagger.Module
import dagger.Provides

@Module
object TestCacheModule {

    @Provides
    @JvmStatic
    fun providesDatabase(application: Application): CacheDatabase {
        return CacheDatabase.getInstance(application)
    }

    @Provides
    @JvmStatic
    fun providesMovieCache(): MovieCache {
        return mock()
    }

}