package com.tzion.jetpackmovies.presentation.di

import com.tzion.jetpackmovies.domain.ManageFavoriteMovie
import com.tzion.jetpackmovies.domain.SeeMovieDetail
import com.tzion.jetpackmovies.domain.boundary.DataGateway
import com.tzion.jetpackmovies.domain.boundary.RemoteFacade
import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.domain.entities.TomatoMeter
import com.tzion.jetpackmovies.domain.posters.FindMoviePosters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun providesTomatoMeterEntity() = TomatoMeter()

    @Provides
    fun providesMovieEntity(tomatoMeter: TomatoMeter) = Movie(tomatoMeter = tomatoMeter)

    @Provides
    fun providesFindMoviesByNameUseCase(remoteFacade: RemoteFacade, movie: Movie) = FindMoviePosters(
        remoteFacade = remoteFacade,
        movie = movie
    )

    @Provides
    fun providesManageFavoriteMovies(dataGateway: DataGateway) = ManageFavoriteMovie(
        dataGateway = dataGateway
    )

    @Provides
    fun providesGetMovieDetail(
        remoteFacade: RemoteFacade,
        movie: Movie
    ): SeeMovieDetail = SeeMovieDetail(
        remoteFacade = remoteFacade,
        movie = movie
    )
}