package com.tzion.jetpackmovies.test

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class TestApplication: Application(), HasActivityInjector {

    @Inject lateinit var injector: DispatchingAndroidInjector<Activity>
    lateinit var appComponent: TestApplicationComponent

//    companion object {
//        fun appComponent(): TestApplicationComponent {
//            return (ApplicationProvider.getApplicationContext<OpenMoviesDatabaseApp>()).
//        }
//    }

    override fun onCreate() {
        super.onCreate()
//        appComponent = DaggerTestApplicationComponent.builder().application(this).build()
        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return injector
    }

}