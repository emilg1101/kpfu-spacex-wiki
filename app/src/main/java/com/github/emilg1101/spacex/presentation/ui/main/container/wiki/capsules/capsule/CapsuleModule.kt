package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.capsule

import com.github.emilg1101.spacex.presentation.adapter.ShortMissionsAdapter
import dagger.Module
import dagger.Provides

@Module
class CapsuleModule {

    @Provides
    @CapsuleQualifier
    fun provideCapsuleSerial(capsuleFragment: CapsuleFragment): String = capsuleFragment.getCapsuleSerial()

    @Provides
    fun provideShortMissionsAdapter(): ShortMissionsAdapter = ShortMissionsAdapter()
}
