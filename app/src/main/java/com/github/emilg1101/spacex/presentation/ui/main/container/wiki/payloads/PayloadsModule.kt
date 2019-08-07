package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads

import com.github.emilg1101.spacex.presentation.adapter.PayloadsAdapter
import dagger.Module
import dagger.Provides

@Module
class PayloadsModule {

    @Provides
    fun providePayloadsAdapter(): PayloadsAdapter = PayloadsAdapter()
}
