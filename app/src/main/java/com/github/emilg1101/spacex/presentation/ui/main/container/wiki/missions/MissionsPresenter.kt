package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.wiki.GetMissionsUseCase
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.MissionItemModel
import com.github.emilg1101.spacex.presentation.model.MissionItemModelMapper
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission.MissionScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MissionsPresenter @Inject constructor() : BasePresenter<MissionsView>() {

    @field:Inject
    @field:WikiQualifier
    lateinit var router: Router

    @field:Inject
    lateinit var getMissionsUseCase: GetMissionsUseCase

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Missions")
        getMissionsUseCase.getMissions()
            .compose(PresentationSingleTransformer())
            .map(MissionItemModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({
                viewState.showMissions(it)
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
    }

    fun openMission(model: MissionItemModel) {
        router.navigateTo(MissionScreen(model.id))
    }
}
