package com.tzion.openmoviesdatabase.di

import android.app.Application
import com.tzion.domain.movie.MovieRepository
import com.tzion.openmoviesdatabase.di.module.PresentationModule
import com.tzion.openmoviesdatabase.di.module.UiModule
import com.tzion.openmoviesdatabase.test.TestApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    TestApplicationModule::class,
    TestCacheModule::class,
    TestDataModule::class,
    PresentationModule::class,
    UiModule::class,
    TestRemoteModule::class])
interface TestApplicationComponent : ApplicationComponent {

    fun moviesRepository(): MovieRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): TestApplicationComponent.Builder

        fun build(): TestApplicationComponent
    }

    fun inject(application: TestApplication)

}