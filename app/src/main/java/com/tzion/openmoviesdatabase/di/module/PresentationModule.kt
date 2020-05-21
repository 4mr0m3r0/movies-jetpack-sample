package com.tzion.openmoviesdatabase.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tzion.openmoviesdatabase.di.ViewModelFactory
import com.tzion.openmoviesdatabase.di.ViewModelKey
import com.tzion.openmoviesdatabase.movies.presentation.FindMoviesViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class PresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(FindMoviesViewModel::class)
    abstract fun bindDisplayClientsViewModel(viewModel: FindMoviesViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}