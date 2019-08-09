package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.core

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.CoreModel
import com.github.emilg1101.spacex.presentation.model.MissionItemShortModel
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class CorePresenter @Inject constructor(@CoreQualifier val serial: String) : BasePresenter<CoreView>() {

    @field:Inject
    @field:CoreQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle(serial)
        val model = CoreModel(
            "B1006",
            "1",
            "destroyed",
            "2014-04-18T19:25:00",
            arrayListOf(
                MissionItemShortModel("CRS-3", 14)
            ),
            0,
            0,
            0,
            0,
            0,
            "false",
            "Broke up after sucessful water landing"
        )
        viewState.showBlock(model.block)
        viewState.showStatus(model.status)
        viewState.showLaunchTime(model.launchTime)
        viewState.showDetails(model.details)
        viewState.showReuseCount(model.reuseCount)
        viewState.showRtlsAttempts(model.rtlsAttempts)
        viewState.showRtlsLandings(model.rtlsLandings)
        viewState.showAsdsAttempts(model.asdsAttempts)
        viewState.showAsdsLandings(model.asdsLandings)
        viewState.showWaterLanding(model.waterLanding)
        viewState.showMissions(model.missions)
    }

    fun openMission(model: MissionItemShortModel) {
        router.navigateTo(LaunchScreen(model.flightNumber))
    }
}
