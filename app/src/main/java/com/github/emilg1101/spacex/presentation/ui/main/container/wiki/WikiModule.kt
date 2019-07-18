package com.github.emilg1101.spacex.presentation.ui.main.container.wiki

import com.github.emilg1101.spacex.presentation.base.ContainerFragment
import com.github.emilg1101.spacex.presentation.navigation.LocalCiceroneHolder
import com.github.emilg1101.spacex.presentation.ui.main.container.history.HistoryFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.history.HistoryQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.history.HistoryScope
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

@Module
class WikiModule {

    @Provides
    @WikiQualifier
    fun provideRouter(@WikiQualifier cicerone: Cicerone<Router>): Router = cicerone.router

    @Provides
    @WikiQualifier
    fun provideContainerFragment(wikiFragment: WikiFragment): ContainerFragment = wikiFragment

    @Provides
    @WikiQualifier
    @WikiScope
    fun provideCicerone(@WikiQualifier containerFragment: ContainerFragment): Cicerone<Router> =
        LocalCiceroneHolder.getCicerone(containerFragment::class.java.name)

    @Provides
    @WikiQualifier
    fun provideNavigatorHolder(@WikiQualifier cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @Provides
    @WikiQualifier
    fun provideNavigator(@WikiQualifier containerFragment: ContainerFragment): Navigator =
        SupportAppNavigator(
            containerFragment.baseActivity,
            containerFragment.childFragmentManager,
            containerFragment.containerId
        )
}
