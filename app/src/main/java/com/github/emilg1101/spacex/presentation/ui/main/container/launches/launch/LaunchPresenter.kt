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
import com.yandex.mapkit.geometry.Point
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
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
        val model = LaunchModel(
            74,
            "Iridium NEXT Mission 8",
            "https://images2.imgbox.com/80/ae/1JL1ZzXD_o.png",
            "2019-01-11T07:31:00-08:00",
            "vafb_slc_4e",
            "VAFB SLC 4E",
            Point(34.632093, -120.610829),
            "SpaceX's first flight of 2019 will be the eighth and final launch of its planned Iridium flights. Delivering 10 satellites to low earth orbit, this brings the total up to 75 and completes the Iridium NEXT constellation. This mission launches from SLC-4E at Vandenberg AFB. The booster is expected to land on JRTI.",
            arrayListOf(
                CoreLaunchItemModel("B1049", "JRTI", "ASDS", true, true)
            ),
            arrayListOf(
                PayloadLaunchItemModel("Iridium NEXT 8")
            ),
            arrayListOf(
                LinkLaunchItemModel("wikipedia", "https://en.wikipedia.org/wiki/Iridium_satellite_constellation#Next-generation_constellation"),
                LinkLaunchItemModel("youtube", "https://youtu.be/VshdafZvwrg"),
                LinkLaunchItemModel("Reddit", "https://www.reddit.com/r/spacex/comments/a699fh/iridium_next_constellation_mission_8_launch/")
            ),
            arrayListOf(
                "https://farm9.staticflickr.com/8617/16789019815_f99a165dc5_o.jpg",
                "https://farm8.staticflickr.com/7619/16763151866_35a0a4d8e1_o.jpg",
                "https://farm9.staticflickr.com/8569/16169086873_4d8829832e_o.png"
            ),
            "falcon9",
            "Falcon 9"
        )
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
        router.navigateTo(LaunchEventScreen(LaunchEventModel(1550799900, "Nusantara Satu (PSN-6) / GTO-1 / Beresheet", "", "CCAFS SLC 40")))
    }
}
