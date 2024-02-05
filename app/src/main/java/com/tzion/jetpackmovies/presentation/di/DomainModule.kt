package com.tzion.jetpackmovies.presentation.di

import com.tzion.jetpackmovies.domain.FindMoviesByName
import com.tzion.jetpackmovies.domain.GetMovieDetail
import com.tzion.jetpackmovies.domain.ManageFavoriteMovies
import com.tzion.jetpackmovies.domain.gateway.DataGateway
import com.tzion.jetpackmovies.domain.gateway.NetworkGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun providesFindMoviesByNameUseCase(networkGateway: NetworkGateway) = FindMoviesByName(
        networkGateway = networkGateway
    )

    @Provides
    fun providesManageFavoriteMovies(dataGateway: DataGateway): ManageFavoriteMovies = ManageFavoriteMovies(
        dataGateway = dataGateway
    )

    @Provides
    fun providesGetMovieDetail(networkGateway: NetworkGateway): GetMovieDetail = GetMovieDetail(
        networkGateway = networkGateway
    )
}