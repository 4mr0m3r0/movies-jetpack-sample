package com.tzion.jetpackmovies.ui.di

import android.content.Context
import com.tzion.jetpackmovies.data.cache.Cache
import com.tzion.jetpackmovies.data.cache.CacheImpl
import com.tzion.jetpackmovies.data.cache.database.DatabaseBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class CacheModule {

    companion object {
        @Provides
        fun providesDataBase(@ApplicationContext context: Context): DatabaseBuilder {
            return DatabaseBuilder.getInstance(context)
        }
    }

    @Binds
    abstract fun bindCache(cache: CacheImpl): Cache
}
