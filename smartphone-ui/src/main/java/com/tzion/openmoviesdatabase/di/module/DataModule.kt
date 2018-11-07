package com.tzion.openmoviesdatabase.di.module

import com.tzion.data.movie.MovieDataRepository
import com.tzion.domain.movie.MovieRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: MovieDataRepository): MovieRepository

}