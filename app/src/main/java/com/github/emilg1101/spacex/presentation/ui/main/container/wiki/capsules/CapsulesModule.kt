package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules

import com.github.emilg1101.spacex.presentation.adapter.CapsulesAdapter
import dagger.Module
import dagger.Provides

@Module
class CapsulesModule {

    @Provides
    fun provideCapsulesAdapter(): CapsulesAdapter = CapsulesAdapter()
}
