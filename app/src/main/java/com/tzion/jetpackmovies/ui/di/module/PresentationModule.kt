package com.tzion.jetpackmovies.ui.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tzion.jetpackmovies.ui.di.ViewModelFactory
import com.tzion.jetpackmovies.ui.di.ViewModelKey
import com.tzion.jetpackmovies.presentation.FindMoviesViewModel
import com.tzion.jetpackmovies.presentation.MovieDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(FindMoviesViewModel::class)
    abstract fun bindDisplayClientsViewModel(viewModel: FindMoviesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun bindMovieDetailViewModel(viewModel: MovieDetailViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}