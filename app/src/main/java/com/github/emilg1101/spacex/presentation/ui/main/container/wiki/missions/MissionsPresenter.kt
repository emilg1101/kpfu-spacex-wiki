package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.model.MissionItemModel
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission.MissionScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MissionsPresenter @Inject constructor() : BasePresenter<MissionsView>() {

    @field:Inject
    @field:WikiQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Missions")
        viewState.showMissions(arrayListOf(
            MissionItemModel("F3364BF", "Iridium NEXT"),
            MissionItemModel("F3364BF", "Iridium NEXT"),
            MissionItemModel("F3364BF", "Iridium NEXT"),
            MissionItemModel("F3364BF", "Iridium NEXT"),
            MissionItemModel("F3364BF", "Iridium NEXT")
        ))
    }

    fun openMission(model: MissionItemModel) {
        router.navigateTo(MissionScreen(model.id))
    }
}
