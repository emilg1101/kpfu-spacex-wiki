package com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline

import com.github.emilg1101.spacex.presentation.adapter.HistoryAdapter
import dagger.Module
import dagger.Provides

@Module
class TimelineModule {

    @Provides
    fun provideHistoryAdapter(): HistoryAdapter = HistoryAdapter()
}
