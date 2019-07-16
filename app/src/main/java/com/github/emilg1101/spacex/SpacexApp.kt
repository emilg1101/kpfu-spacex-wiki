package com.github.emilg1101.spacex

import android.content.Context
import android.support.multidex.MultiDex
import com.github.emilg1101.spacex.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.plugins.RxJavaPlugins

class SpacexApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<SpacexApp> {
        return DaggerAppComponent.builder()
            .application(this)
            .create(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler {
            it.printStackTrace()
        }
    }
}
