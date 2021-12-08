package com.tzion.jetpackmovies.ui.di

import com.tzion.jetpackmovies.domain.repository.Repository
import dagger.Module
import dagger.Provides
import io.mockk.mockk
import javax.inject.Singleton

@Module
object TestDataModule {

    @Provides
    @JvmStatic
    @Singleton
    fun providesDataRepository(): Repository {
        return mockk()
    }
}
