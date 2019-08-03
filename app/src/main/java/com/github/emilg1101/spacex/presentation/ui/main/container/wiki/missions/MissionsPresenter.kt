package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.model.MissionItemModel
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiQualifier
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MissionsPresenter @Inject constructor() : BasePresenter<MissionsView>() {

    @field:Inject
    @field:WikiQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Missions")
    }

    fun openMission(model: MissionItemModel) {

    }
}
