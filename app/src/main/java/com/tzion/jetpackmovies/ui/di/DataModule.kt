package com.tzion.jetpackmovies.ui.di

import com.tzion.jetpackmovies.data.DataRepository
import com.tzion.jetpackmovies.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: DataRepository): Repository
}
