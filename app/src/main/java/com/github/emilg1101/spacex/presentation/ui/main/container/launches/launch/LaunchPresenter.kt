package com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.launch.GetLaunchUseCase
import com.github.emilg1101.spacex.presentation.ExternalLinkScreen
import com.github.emilg1101.spacex.presentation.LaunchEventScreen
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.*
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.core.CoreScreen
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload.PayloadScreen
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets.rocket.RocketScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class LaunchPresenter @Inject constructor(@LaunchQualifier val flightNumber: Int) : BasePresenter<LaunchView>() {

    @field:Inject
    @field:LaunchQualifier
    lateinit var router: Router

    @field:Inject
    lateinit var getLaunchUseCase: GetLaunchUseCase

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Launch")
        getLaunchUseCase.getLaunch(flightNumber)
            .compose(PresentationSingleTransformer())
            .map(LaunchModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({ model ->
                viewState.showMission(model.missionName)
                viewState.showLaunchPad(model.launchPadName)
                viewState.showLaunchTime(model.launchTime)
                viewState.showDetails(model.details)
                viewState.showRocket(model.rocketName)
                viewState.showPatch(model.missionPatch)
                viewState.showLaunchPadOnMap(model.launchPadCoords)
                viewState.showCores(model.cores)
                viewState.showPayloads(model.payloads)
                viewState.showLinks(model.links)
                viewState.showImages(model.images)
                viewState.setRocketId(model.rocketId)
                viewState.setLaunchPadId(model.launchPadId)
                if (model.upcoming) {
                    viewState.showRemind()
                }
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
    }

    fun openRocket(id: String) {
        router.navigateTo(RocketScreen(id))
    }

    fun openCore(core: CoreLaunchItemModel) {
        router.navigateTo(CoreScreen(core.coreSerial))
    }

    fun openPayload(payload: PayloadLaunchItemModel) {
        router.navigateTo(PayloadScreen(payload.payloadId))
    }

    fun openLink(link: LinkLaunchItemModel) {
        router.navigateTo(ExternalLinkScreen(link.link))
    }

    fun openLaunchPad(id: String) {
        //TODO in a wonderful future
    }

    fun onRemind() {
        getLaunchUseCase.getLaunch(flightNumber)
            .compose(PresentationSingleTransformer())
            .map(LaunchEventModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({
                router.navigateTo(LaunchEventScreen(it))
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
    }
}
