package com.tzion.openmoviesdatabase.test

import android.app.Activity
import android.app.Application
import androidx.test.core.app.ApplicationProvider
import com.tzion.openmoviesdatabase.OpenMoviesDatabaseApp
import com.tzion.openmoviesdatabase.di.DaggerTestApplicationComponent
import com.tzion.openmoviesdatabase.di.TestApplicationComponent
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
        appComponent = DaggerTestApplicationComponent.builder().application(this).build()
        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return injector
    }

}