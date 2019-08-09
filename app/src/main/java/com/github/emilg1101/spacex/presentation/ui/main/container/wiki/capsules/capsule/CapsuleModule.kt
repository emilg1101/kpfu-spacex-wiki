package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.capsule

import com.github.emilg1101.spacex.presentation.adapter.ShortMissionsAdapter
import com.github.emilg1101.spacex.presentation.navigation.LocalCiceroneHolder
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
class CapsuleModule {

    @Provides
    @CapsuleQualifier
    fun provideRouter(capsuleFragment: CapsuleFragment): Router =
        LocalCiceroneHolder.getCicerone((capsuleFragment.parentFragment
            ?: capsuleFragment)::class.java.name).router

    @Provides
    @CapsuleQualifier
    fun provideCapsuleSerial(capsuleFragment: CapsuleFragment): String = capsuleFragment.getCapsuleSerial()

    @Provides
    fun provideShortMissionsAdapter(): ShortMissionsAdapter = ShortMissionsAdapter()
}
