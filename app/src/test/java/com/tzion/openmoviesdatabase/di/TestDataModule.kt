package com.tzion.openmoviesdatabase.di

import com.nhaarman.mockito_kotlin.mock
import com.tzion.domain.movie.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object TestDataModule {

    @Provides
    @JvmStatic
    @Singleton
    fun providesDataRepository(): MovieRepository {
        return mock()
    }

}