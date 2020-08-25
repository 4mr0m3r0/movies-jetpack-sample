package com.tzion.jetpackmovies.ui.di.module

import com.tzion.jetpackmovies.data.DataRepository
import com.tzion.jetpackmovies.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: DataRepository): Repository

}