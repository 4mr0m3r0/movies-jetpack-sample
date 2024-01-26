package com.tzion.jetpackmovies.presentation.di

import com.tzion.jetpackmovies.domain.FindMoviesByName
import com.tzion.jetpackmovies.domain.gateway.NetworkGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface DomainModule {
    @Provides
    fun providesFindMoviesByNameUseCase(networkGateway: NetworkGateway) = FindMoviesByName(
        networkGateway = networkGateway
    )
}