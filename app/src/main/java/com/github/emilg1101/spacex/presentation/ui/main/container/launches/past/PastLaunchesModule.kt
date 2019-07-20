package com.github.emilg1101.spacex.presentation.ui.main.container.launches.past

import com.github.emilg1101.spacex.presentation.adapter.PastLaunchesAdapter
import dagger.Module
import dagger.Provides

@Module
class PastLaunchesModule {

    @Provides
    fun provideAdapter() = PastLaunchesAdapter()
}
