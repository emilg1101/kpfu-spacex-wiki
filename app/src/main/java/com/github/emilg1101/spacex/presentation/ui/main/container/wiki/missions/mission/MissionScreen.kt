package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission

import ru.terrakok.cicerone.android.support.SupportAppScreen

class MissionScreen(private val missionId: String) : SupportAppScreen() {

    override fun getScreenKey() = MissionFragment.TAG

    override fun getFragment() = MissionFragment.newInstance(missionId)
}
