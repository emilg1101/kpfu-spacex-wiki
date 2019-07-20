package com.github.emilg1101.spacex.presentation.ui.main.container.launches.upcoming

import com.github.emilg1101.spacex.presentation.adapter.UpcomingLaunchesAdapter
import dagger.Module
import dagger.Provides

@Module
class UpcomingLaunchesModule {

    @Provides
    fun provideAdapter() = UpcomingLaunchesAdapter()
}
