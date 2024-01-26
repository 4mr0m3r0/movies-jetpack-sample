package com.tzion.jetpackmovies.presentation.di

import android.content.Context
import com.tzion.jetpackmovies.data.DataRoom
import com.tzion.jetpackmovies.data.database.DatabaseBuilder
import com.tzion.jetpackmovies.domain.gateway.DataGateway
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindDataRepository(dataRoom: DataRoom): DataGateway

    companion object {
        @Provides
        fun providesDataBase(@ApplicationContext context: Context): DatabaseBuilder {
            return DatabaseBuilder.getInstance(context)
        }
    }
}
