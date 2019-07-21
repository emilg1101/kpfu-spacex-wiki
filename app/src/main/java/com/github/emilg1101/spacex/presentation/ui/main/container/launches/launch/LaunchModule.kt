package com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch

import com.github.emilg1101.spacex.presentation.navigation.LocalCiceroneHolder
import dagger.Module
import dagger.Provides

@Module
class LaunchModule {

    @Provides
    @LaunchQualifier
    fun provideRouter(launchFragment: LaunchFragment) = LocalCiceroneHolder.getCicerone(launchFragment::class.java.name).router
}
