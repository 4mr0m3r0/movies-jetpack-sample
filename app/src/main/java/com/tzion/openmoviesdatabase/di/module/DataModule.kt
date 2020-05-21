package com.tzion.openmoviesdatabase.di.module

import com.tzion.openmoviesdatabase.movies.data.DataRepository
import com.tzion.openmoviesdatabase.movies.domain.repository.Repository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: DataRepository): Repository

}