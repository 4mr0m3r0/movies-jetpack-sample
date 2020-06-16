package com.tzion.jetpackmovies.ui.di

import android.app.Application
import com.tzion.jetpackmovies.ui.di.module.PresentationModule
import com.tzion.jetpackmovies.domain.repository.Repository
import com.tzion.jetpackmovies.test.TestApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    TestApplicationModule::class,
//    TestCacheModule::class,
    TestDataModule::class,
    PresentationModule::class,
    TestRemoteModule::class])
interface TestApplicationComponent : ApplicationComponent {

    fun moviesRepository(): Repository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): TestApplicationComponent.Builder

        fun build(): TestApplicationComponent
    }

    fun inject(application: TestApplication)

}