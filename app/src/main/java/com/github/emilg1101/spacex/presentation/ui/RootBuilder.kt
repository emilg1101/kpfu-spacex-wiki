package com.github.emilg1101.spacex.presentation.ui

import com.github.emilg1101.spacex.presentation.ui.main.MainActivity
import com.github.emilg1101.spacex.presentation.ui.main.MainBuilder
import com.github.emilg1101.spacex.presentation.ui.main.MainModule
import com.github.emilg1101.spacex.presentation.ui.main.MainScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RootBuilder {

    @ContributesAndroidInjector(modules = [MainModule::class, MainBuilder::class])
    @MainScope
    abstract fun buildMainActivity(): MainActivity
}
