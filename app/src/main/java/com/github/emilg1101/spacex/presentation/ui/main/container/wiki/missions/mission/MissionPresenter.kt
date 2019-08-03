package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import javax.inject.Inject

@InjectViewState
class MissionPresenter @Inject constructor(@MissionQualifier val missionId: String) : BasePresenter<MissionView>() {

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle(missionId)
    }
}
