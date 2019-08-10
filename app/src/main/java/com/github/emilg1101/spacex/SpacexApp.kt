package com.github.emilg1101.spacex

import android.content.Context
import android.support.multidex.MultiDex
import com.github.emilg1101.spacex.di.DaggerAppComponent
import com.yandex.mapkit.MapKitFactory
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors

class SpacexApp : DaggerApplication() {

    companion object {
        private val NETWORK_THREAD_POOL = Executors.newFixedThreadPool(2)
        val NETWORK_SCHEDULER = Schedulers.from(NETWORK_THREAD_POOL)
    }

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
        MapKitFactory.setApiKey("8e333c38-ca24-4e13-9925-ea4103d2b1e8")
        RxJavaPlugins.setErrorHandler {
            it.printStackTrace()
        }
    }
}
