package com.github.emilg1101.spacex.presentation.ui.main.container.launches

import com.github.emilg1101.spacex.presentation.base.ContainerFragment
import com.github.emilg1101.spacex.presentation.navigation.LocalCiceroneHolder
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

@Module
class LaunchesModule {

    @Provides
    @LaunchesQualifier
    fun provideRouter(@LaunchesQualifier cicerone: Cicerone<Router>): Router = cicerone.router

    @Provides
    @LaunchesQualifier
    fun provideContainerFragment(launchesFragment: LaunchesFragment): ContainerFragment = launchesFragment

    @Provides
    @LaunchesQualifier
    @LaunchesScope
    fun provideCicerone(@LaunchesQualifier containerFragment: ContainerFragment): Cicerone<Router> =
        LocalCiceroneHolder.getCicerone(containerFragment::class.java.name)

    @Provides
    @LaunchesQualifier
    fun provideNavigatorHolder(@LaunchesQualifier cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @Provides
    @LaunchesQualifier
    fun provideNavigator(@LaunchesQualifier containerFragment: ContainerFragment): Navigator =
        SupportAppNavigator(
            containerFragment.baseActivity,
            containerFragment.childFragmentManager,
            containerFragment.containerId
        )

}
