package com.tzion.openmoviesdatabase.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tzion.openmoviesdatabase.di.ViewModelFactory
import com.tzion.presentation.movie.FindMoviesViewModel
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

    //Add more view models here. In case it is needed

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)