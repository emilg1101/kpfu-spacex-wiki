package com.github.emilg1101.spacex.presentation.ui.main.container.history

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
class HistoryModule {

    @Provides
    @HistoryQualifier
    fun provideRouter(@HistoryQualifier cicerone: Cicerone<Router>): Router = cicerone.router

    @Provides
    @HistoryQualifier
    fun provideContainerFragment(historyFragment: HistoryFragment): ContainerFragment = historyFragment

    @Provides
    @HistoryQualifier
    @HistoryScope
    fun provideCicerone(@HistoryQualifier containerFragment: ContainerFragment): Cicerone<Router> =
        LocalCiceroneHolder.getCicerone(containerFragment::class.java.name)

    @Provides
    @HistoryQualifier
    fun provideNavigatorHolder(@HistoryQualifier cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @Provides
    @HistoryQualifier
    fun provideNavigator(@HistoryQualifier containerFragment: ContainerFragment): Navigator =
        SupportAppNavigator(
            containerFragment.baseActivity,
            containerFragment.childFragmentManager,
            containerFragment.containerId
        )

}
