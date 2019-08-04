package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions

import com.github.emilg1101.spacex.presentation.adapter.MissionsAdapter
import dagger.Module
import dagger.Provides

@Module
class MissionsModule {

    @Provides
    fun provideMissionsAdapter(): MissionsAdapter = MissionsAdapter()
}
