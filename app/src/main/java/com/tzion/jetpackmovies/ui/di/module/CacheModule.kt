package com.tzion.jetpackmovies.ui.di.module

import android.content.Context
import com.tzion.jetpackmovies.data.cache.Cache
import com.tzion.jetpackmovies.data.cache.CacheImpl
import com.tzion.jetpackmovies.data.cache.database.DatabaseBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class CacheModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesDataBase(context: Context): DatabaseBuilder {
            return DatabaseBuilder.getInstance(context)
        }
    }

    @Binds
    abstract fun bindCache(cache: CacheImpl): Cache

}