package com.tzion.jetpackmovies

import android.app.Activity
import android.app.Application
import com.tzion.jetpackmovies.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class JetpackMoviesApp: Application(), HasActivityInjector {

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
        DaggerApplicationComponent.builder().application(this).build().inject(this)
    }


}