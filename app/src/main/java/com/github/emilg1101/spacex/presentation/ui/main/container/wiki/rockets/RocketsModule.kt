package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets

import com.github.emilg1101.spacex.presentation.adapter.RocketsAdapter
import dagger.Module
import dagger.Provides

@Module
class RocketsModule {

    @Provides
    fun provideRocketsAdapter(): RocketsAdapter = RocketsAdapter()
}
