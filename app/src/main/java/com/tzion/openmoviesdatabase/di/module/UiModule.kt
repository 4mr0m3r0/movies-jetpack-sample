package com.tzion.openmoviesdatabase.di.module

import com.tzion.openmoviesdatabase.movies.ui.displayMovies.DisplayMoviesByNameActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @ContributesAndroidInjector
    abstract fun contributeDisplayMoviesByNameActivity(): DisplayMoviesByNameActivity

}