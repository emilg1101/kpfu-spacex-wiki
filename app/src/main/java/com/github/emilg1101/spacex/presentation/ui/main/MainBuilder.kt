package com.github.emilg1101.spacex.presentation.ui.main

import com.github.emilg1101.spacex.presentation.ui.main.container.BottomMainContainerBuilder
import com.github.emilg1101.spacex.presentation.ui.main.container.BottomMainContainerFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.BottomMainContainerModule
import com.github.emilg1101.spacex.presentation.ui.main.container.BottomMainContainerScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainBuilder {

    @ContributesAndroidInjector(modules = [BottomMainContainerModule::class, BottomMainContainerBuilder::class])
    @BottomMainContainerScope
    abstract fun buildBottomMainContainerFragment(): BottomMainContainerFragment
}
