package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission

import dagger.Module
import dagger.Provides

@Module
class MissionModule {

    @Provides
    @MissionQualifier
    fun provideMissionId(missionFragment: MissionFragment): String = missionFragment.getMissionId()
}
