package com.tzion.openmoviesdatabase.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class TestApplicationModule {

    @Binds
    abstract fun bindContext(application: Application): Context

}