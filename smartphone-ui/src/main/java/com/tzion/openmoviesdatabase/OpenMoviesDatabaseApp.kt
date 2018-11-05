package com.tzion.openmoviesdatabase

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class OpenMoviesDatabaseApp: Application(), HasActivityInjector {

    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = androidInjector

    override fun onCreate() {
        super.onCreate()
        setupTimber()
        setupDagger()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun setupDagger() {

    }


}