package com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.ExternalLinkScreen
import com.github.emilg1101.spacex.presentation.LaunchEventScreen
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.*
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.LaunchesQualifier
import com.yandex.mapkit.geometry.Point
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class LaunchPresenter @Inject constructor(@LaunchQualifier val flightNumber: Int) : BasePresenter<LaunchView>() {

    @field:Inject
    @field:LaunchesQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
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
            arrayListOf(),
            "falcon9",
            "Falcon 9"
        )

        viewState.setToolbarTitle("Launch")
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
    }

    fun openRocket(id: String) {

    }

    fun openCore(core: CoreLaunchItemModel) {

    }

    fun openPayload(payload: PayloadLaunchItemModel) {

    }

    fun openLink(link: LinkLaunchItemModel) {
        router.navigateTo(ExternalLinkScreen(link.link))
    }

    fun openLaunchPad(id: String) {

    }

    fun onRemind() {
        router.navigateTo(LaunchEventScreen(LaunchEventModel(1550799900, "Nusantara Satu (PSN-6) / GTO-1 / Beresheet", "", "CCAFS SLC 40")))
    }
}
