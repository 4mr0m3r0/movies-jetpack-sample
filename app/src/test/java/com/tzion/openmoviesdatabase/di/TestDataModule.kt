package com.tzion.openmoviesdatabase.di

import com.nhaarman.mockito_kotlin.mock
import com.tzion.openmoviesdatabase.movies.domain.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object TestDataModule {

    @Provides
    @JvmStatic
    @Singleton
    fun providesDataRepository(): Repository {
        return mock()
    }

}