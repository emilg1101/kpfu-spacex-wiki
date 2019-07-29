package com.github.emilg1101.spacex.presentation.ui.main.container.history

import com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline.TimelineFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline.TimelineModule
import com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline.TimelineScope
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchModule
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class HistoryBuilder {

    @ContributesAndroidInjector(modules = [TimelineModule::class])
    @TimelineScope
    abstract fun buildTimelineFragment(): TimelineFragment

    @ContributesAndroidInjector(modules = [LaunchModule::class])
    @LaunchScope
    abstract fun provideLaunchFragment(): LaunchFragment
}