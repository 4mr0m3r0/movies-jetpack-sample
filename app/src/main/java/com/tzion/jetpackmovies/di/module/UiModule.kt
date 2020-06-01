package com.tzion.jetpackmovies.di.module

import com.tzion.jetpackmovies.ui.findMovies.FindMoviesByNameActivity
import com.tzion.jetpackmovies.ui.movieDetail.MovieDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @ContributesAndroidInjector
    abstract fun contributeDisplayMoviesByNameActivity(): FindMoviesByNameActivity

    @ContributesAndroidInjector
    abstract fun contributeMovieDetailActivity(): MovieDetailActivity

}