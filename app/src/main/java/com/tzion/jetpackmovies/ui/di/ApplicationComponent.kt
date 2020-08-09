package com.tzion.jetpackmovies.ui.di

import android.app.Application
import android.content.Context
import com.tzion.jetpackmovies.JetpackMoviesApp
import com.tzion.jetpackmovies.ui.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun provideContext(): Context

}