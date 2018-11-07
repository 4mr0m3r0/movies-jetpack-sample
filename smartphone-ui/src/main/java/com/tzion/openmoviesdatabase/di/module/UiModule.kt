package com.tzion.openmoviesdatabase.di.module

import com.tzion.domain.executor.PostExecutionThread
import com.tzion.openmoviesdatabase.UiThread
import com.tzion.openmoviesdatabase.movie.displayMovies.DisplayMoviesActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributeDisplayMoviesActivity(): DisplayMoviesActivity

}