package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.core

import com.github.emilg1101.spacex.presentation.adapter.ShortMissionsAdapter
import com.github.emilg1101.spacex.presentation.navigation.LocalCiceroneHolder
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
class CoreModule {

    @Provides
    @CoreQualifier
    fun provideRouter(coreFragment: CoreFragment): Router =
        LocalCiceroneHolder.getCicerone((coreFragment.parentFragment
            ?: coreFragment)::class.java.name).router

    @Provides
    @CoreQualifier
    fun provideSerial(coreFragment: CoreFragment): String = coreFragment.getSerial()

    @Provides
    fun provideMissionsAdapter(): ShortMissionsAdapter = ShortMissionsAdapter()
}
