package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload

import com.github.emilg1101.spacex.presentation.adapter.OrbitParamsAdapter
import dagger.Module
import dagger.Provides

@Module
class PayloadModule {

    @Provides
    @PayloadQualifier
    fun providePayloadId(payloadFragment: PayloadFragment): String = payloadFragment.getPayloadId()

    @Provides
    fun provideOrbitParamsAdapter(): OrbitParamsAdapter = OrbitParamsAdapter()
}
