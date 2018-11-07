package com.tzion.openmoviesdatabase.di.module

import android.app.Application
import com.tzion.cache.CacheDatabase
import com.tzion.cache.movie.MovieCacheImpl
import com.tzion.data.movie.repository.MovieCache
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class CacheModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesDataBase(application: Application): CacheDatabase {
            return CacheDatabase.getInstance(application)
        }
    }

    @Binds
    abstract fun bindMovieCache(movieCache: MovieCacheImpl): MovieCache

}