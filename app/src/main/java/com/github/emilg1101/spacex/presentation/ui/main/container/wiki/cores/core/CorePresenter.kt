package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.core

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.wiki.GetCoreUseCase
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.CoreModelMapper
import com.github.emilg1101.spacex.presentation.model.MissionItemShortModel
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class CorePresenter @Inject constructor(@CoreQualifier val serial: String) : BasePresenter<CoreView>() {

    @field:Inject
    @field:CoreQualifier
    lateinit var router: Router

    @field:Inject
    lateinit var getCoreUseCase: GetCoreUseCase

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle(serial)
        getCoreUseCase.getCore(serial)
            .compose(PresentationSingleTransformer())
            .map(CoreModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({ model ->
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
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
    }

    fun openMission(model: MissionItemShortModel) {
        router.navigateTo(LaunchScreen(model.flightNumber))
    }
}
