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
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.core.CoreFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.core.CoreModule
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.core.CoreScope
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload.PayloadFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload.PayloadModule
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload.PayloadScope
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets.rocket.RocketFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets.rocket.RocketModule
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets.rocket.RocketScope
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

    @ContributesAndroidInjector(modules = [CoreModule::class])
    @CoreScope
    abstract fun provideCoreFragment(): CoreFragment

    @ContributesAndroidInjector(modules = [RocketModule::class])
    @RocketScope
    abstract fun provideRocketFragment(): RocketFragment

    @ContributesAndroidInjector(modules = [PayloadModule::class])
    @PayloadScope
    abstract fun providePayloadFragment(): PayloadFragment
}
