package com.github.emilg1101.spacex.presentation.ui.main

import com.github.emilg1101.spacex.presentation.base.ContainerActivity
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

@Module
class MainModule {

    @Provides
    @MainQualifier
    fun provideMainRouter(): Router = Router()

    @Provides
    @MainQualifier
    fun provideContainerActivity(mainActivity: MainActivity): ContainerActivity = mainActivity

    @Provides
    @MainQualifier
    @MainScope
    fun provideCicerone(@MainQualifier router: Router): Cicerone<Router> = Cicerone.create(router)

    @Provides
    @MainQualifier
    fun provideNavigatorHolder(@MainQualifier cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @Provides
    @MainQualifier
    fun provideNavigator(@MainQualifier containerActivity: ContainerActivity): Navigator =
        SupportAppNavigator(containerActivity, containerActivity.supportFragmentManager, containerActivity.containerId)
}
