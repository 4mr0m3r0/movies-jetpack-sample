package com.tzion.jetpackmovies.ui.di.module

import com.tzion.jetpackmovies.ui.MainActivity
import com.tzion.jetpackmovies.ui.di.ApplicationComponent
import com.tzion.jetpackmovies.ui.di.FeatureScope
import com.tzion.jetpackmovies.ui.findMovies.FindMoviesByNameFragment
import com.tzion.jetpackmovies.ui.movieDetail.MovieDetailFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [
        PresentationModule::class,
        DataModule::class,
        CacheModule::class,
        RemoteModule::class
    ], dependencies = [ApplicationComponent::class]
)
interface MoviesComponent {

    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent): MoviesComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: FindMoviesByNameFragment)
    fun inject(fragment: MovieDetailFragment)

}