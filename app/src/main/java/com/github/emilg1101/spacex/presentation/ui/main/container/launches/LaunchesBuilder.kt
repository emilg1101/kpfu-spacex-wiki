package com.github.emilg1101.spacex.presentation.ui.main.container.launches

import com.github.emilg1101.spacex.presentation.ui.main.container.launches.container.LaunchesContainerFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.container.LaunchesContainerModule
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.container.LaunchesContainerScope
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchModule
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchScope
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.tab.LaunchesTabFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.tab.LaunchesTabModule
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.tab.LaunchesTabScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LaunchesBuilder {

    @ContributesAndroidInjector(modules = [LaunchesContainerModule::class])
    @LaunchesContainerScope
    abstract fun provideLaunchesContainerFragment(): LaunchesContainerFragment

    @ContributesAndroidInjector(modules = [LaunchesTabModule::class])
    @LaunchesTabScope
    abstract fun provideLaunchesTabFragment(): LaunchesTabFragment

    @ContributesAndroidInjector(modules = [LaunchModule::class])
    @LaunchScope
    abstract fun provideLaunchFragment(): LaunchFragment
}
