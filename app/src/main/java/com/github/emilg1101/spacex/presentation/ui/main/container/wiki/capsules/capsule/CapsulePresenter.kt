package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.capsule

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.wiki.GetCapsuleUseCase
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.CapsuleModelMapper
import com.github.emilg1101.spacex.presentation.model.MissionItemShortModel
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class CapsulePresenter @Inject constructor(@CapsuleQualifier val capsuleSerial: String) : BasePresenter<CapsuleView>() {

    @field:Inject
    @field:CapsuleQualifier
    lateinit var router: Router

    @field:Inject
    lateinit var getCapsuleUseCase: GetCapsuleUseCase

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle(capsuleSerial)
        getCapsuleUseCase.getCapsule(capsuleSerial)
            .compose(PresentationSingleTransformer())
            .map(CapsuleModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({ model ->
                viewState.showDetails(model.details)
                viewState.showStatus(model.status)
                viewState.showLaunchTime(model.launchTime)
                viewState.showLandings(model.landings)
                viewState.showType(model.type)
                viewState.showReuseCount(model.reuse)
                viewState.showMissions(model.missions)
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
    }

    fun openMission(model: MissionItemShortModel) {
        router.navigateTo(LaunchScreen(model.flightNumber))
    }
}
