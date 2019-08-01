package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.capsule

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.CapsuleModel
import com.github.emilg1101.spacex.presentation.model.MissionItemShortModel
import javax.inject.Inject

@InjectViewState
class CapsulePresenter @Inject constructor(@CapsuleQualifier val capsuleSerial: String) : BasePresenter<CapsuleView>() {

    override fun onFirstViewAttach() {
        val model = CapsuleModel(
            "C101",
            "retired",
            "2010-12-08T15:43:00",
            arrayListOf(
                MissionItemShortModel("COTS 1", 7)
            ),
            "0",
            "Dragon 1.0",
            "Pressure vessel used for Dragon 2 structural testing. Rumored to be repurposed for first Red Dragon Mission",
            "1"
        )
        viewState.setToolbarTitle(capsuleSerial)
        viewState.showDetails(model.details)
        viewState.showStatus(model.status)
        viewState.showLaunchTime(model.launchTime)
        viewState.showLandings(model.landings)
        viewState.showType(model.type)
        viewState.showReuseCount(model.reuse)
        viewState.showMissions(model.missions)
    }

    fun openMission(model: MissionItemShortModel) {

    }
}
