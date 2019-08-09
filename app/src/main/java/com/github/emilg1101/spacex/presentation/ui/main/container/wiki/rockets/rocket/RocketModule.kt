package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets.rocket

import com.github.emilg1101.spacex.presentation.navigation.LocalCiceroneHolder
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
class RocketModule {

    @Provides
    @RocketQualifier
    fun provideRouter(rocketFragment: RocketFragment): Router =
        LocalCiceroneHolder.getCicerone((rocketFragment.parentFragment
            ?: rocketFragment)::class.java.name).router

    @Provides
    @RocketQualifier
    fun provideRocketId(rocketFragment: RocketFragment): String = rocketFragment.getRocketId()
}
