package com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch

import com.github.emilg1101.spacex.presentation.adapter.LaunchCoresAdapter
import com.github.emilg1101.spacex.presentation.adapter.LaunchImagesAdapter
import com.github.emilg1101.spacex.presentation.adapter.LaunchPayloadsAdapter
import com.github.emilg1101.spacex.presentation.navigation.LocalCiceroneHolder
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
class LaunchModule {

    @Provides
    @LaunchQualifier
    fun provideRouter(launchFragment: LaunchFragment): Router =
        LocalCiceroneHolder.getCicerone((launchFragment.parentFragment ?: launchFragment)::class.java.name).router

    @Provides
    @LaunchQualifier
    fun provideFlightNumber(launchFragment: LaunchFragment): Int = launchFragment.getFlightNumber()

    @Provides
    fun provideLaunchCoresAdapter(): LaunchCoresAdapter = LaunchCoresAdapter()

    @Provides
    fun provideLaunchPayloadsAdapter(): LaunchPayloadsAdapter = LaunchPayloadsAdapter()

    @Provides
    fun provideLaunchImagesAdapter(): LaunchImagesAdapter = LaunchImagesAdapter()
}
