package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission

import com.github.emilg1101.spacex.presentation.adapter.MissionPayloadsAdapter
import com.github.emilg1101.spacex.presentation.navigation.LocalCiceroneHolder
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchQualifier
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
class MissionModule {

    @Provides
    @MissionQualifier
    fun provideRouter(missionFragment: MissionFragment): Router =
        LocalCiceroneHolder.getCicerone((missionFragment.parentFragment ?: missionFragment)::class.java.name).router

    @Provides
    @MissionQualifier
    fun provideMissionId(missionFragment: MissionFragment): String = missionFragment.getMissionId()

    @Provides
    fun provideMissionPayloadsAdapter(): MissionPayloadsAdapter = MissionPayloadsAdapter()
}
