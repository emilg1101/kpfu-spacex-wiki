package com.github.emilg1101.spacex.presentation.ui.main.container

import com.github.emilg1101.spacex.presentation.ui.main.container.history.HistoryFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.history.HistoryModule
import com.github.emilg1101.spacex.presentation.ui.main.container.history.HistoryScope
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.LaunchesFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.LaunchesModule
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.LaunchesScope
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiModule
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class BottomMainContainerBuilder {

    @ContributesAndroidInjector(modules = [LaunchesModule::class])
    @LaunchesScope
    abstract fun buildLaunchesFragment(): LaunchesFragment

    @ContributesAndroidInjector(modules = [WikiModule::class])
    @WikiScope
    abstract fun buildWikiFragment(): WikiFragment

    @ContributesAndroidInjector(modules = [HistoryModule::class])
    @HistoryScope
    abstract fun buildHistoryFragment(): HistoryFragment
}
