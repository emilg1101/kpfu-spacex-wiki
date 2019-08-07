package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores

import com.github.emilg1101.spacex.presentation.adapter.CoresAdapter
import dagger.Module
import dagger.Provides

@Module
class CoresModule {

    @Provides
    fun provideCoresAdapter(): CoresAdapter = CoresAdapter()
}
