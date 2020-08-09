package com.tzion.jetpackmovies.ui.di.module

import com.tzion.jetpackmovies.data.DataRepository
import com.tzion.jetpackmovies.domain.repository.Repository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: DataRepository): Repository

}