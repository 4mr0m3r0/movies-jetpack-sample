package com.tzion.jetpackmovies

import android.app.Application
import com.tzion.jetpackmovies.ui.di.ApplicationComponent
import com.tzion.jetpackmovies.ui.di.DaggerApplicationComponent
import timber.log.Timber

class JetpackMoviesApp: Application() {

    val appComponent: ApplicationComponent by lazy {
        initializeDaggerComponent()
    }

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initializeDaggerComponent(): ApplicationComponent = DaggerApplicationComponent
        .factory()
        .create(applicationContext)


}