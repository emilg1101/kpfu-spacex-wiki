package com.github.emilg1101.spacex.presentation.ui.main.container.history

import com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline.TimelineFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline.TimelineModule
import com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline.TimelineScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class HistoryBuilder {

    @ContributesAndroidInjector(modules = [TimelineModule::class])
    @TimelineScope
    abstract fun buildTimelineFragment(): TimelineFragment
}