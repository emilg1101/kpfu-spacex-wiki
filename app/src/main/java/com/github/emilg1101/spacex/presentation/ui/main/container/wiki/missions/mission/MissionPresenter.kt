package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.ExternalLinkScreen
import com.github.emilg1101.spacex.presentation.model.PayloadMissionItemModel
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MissionPresenter @Inject constructor(@MissionQualifier val missionId: String) : BasePresenter<MissionView>() {

    @field:Inject
    @field:MissionQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle(missionId)
    }

    fun openPayload(model: PayloadMissionItemModel) {

    }

    fun openLink(link: String) {
        router.navigateTo(ExternalLinkScreen(link))
    }
}
