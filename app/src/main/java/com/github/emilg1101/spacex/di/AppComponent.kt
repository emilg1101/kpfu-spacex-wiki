package com.github.emilg1101.spacex.di

import android.app.Application
import com.github.emilg1101.spacex.SpacexApp
import com.github.emilg1101.spacex.data.DataModule
import com.github.emilg1101.spacex.di.module.AppModule
import com.github.emilg1101.spacex.presentation.PresentationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        DataModule::class,
        PresentationModule::class
    ]
)
interface AppComponent : AndroidInjector<SpacexApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<SpacexApp>() {

        @BindsInstance
        abstract fun application(application: Application): Builder
    }
}
