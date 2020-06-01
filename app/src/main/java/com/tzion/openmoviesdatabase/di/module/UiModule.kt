package com.tzion.openmoviesdatabase.di.module

import com.tzion.openmoviesdatabase.movies.ui.findMovies.FindMoviesByNameActivity
import com.tzion.openmoviesdatabase.movies.ui.movieDetail.MovieDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @ContributesAndroidInjector
    abstract fun contributeDisplayMoviesByNameActivity(): FindMoviesByNameActivity

    @ContributesAndroidInjector
    abstract fun contributeMovieDetailActivity(): MovieDetailActivity

}