package com.github.emilg1101.spacex.presentation.ui.main.container.launches

import com.github.emilg1101.spacex.presentation.ui.main.container.launches.container.LaunchesContainerFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.container.LaunchesContainerModule
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.container.LaunchesContainerScope
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchModule
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchScope
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.past.PastLaunchesFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.past.PastLaunchesModule
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.past.PastLaunchesScope
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.upcoming.UpcomingLaunchesFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.upcoming.UpcomingLaunchesModule
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.upcoming.UpcomingLaunchesScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LaunchesBuilder {

    @ContributesAndroidInjector(modules = [LaunchesContainerModule::class])
    @LaunchesContainerScope
    abstract fun provideLaunchesContainerFragment(): LaunchesContainerFragment

    @ContributesAndroidInjector(modules = [UpcomingLaunchesModule::class])
    @UpcomingLaunchesScope
    abstract fun provideUpcomingLaunchesFragment(): UpcomingLaunchesFragment

    @ContributesAndroidInjector(modules = [PastLaunchesModule::class])
    @PastLaunchesScope
    abstract fun providePastLaunchesFragment(): PastLaunchesFragment

    @ContributesAndroidInjector(modules = [LaunchModule::class])
    @LaunchScope
    abstract fun provideLaunchFragment(): LaunchFragment
}
