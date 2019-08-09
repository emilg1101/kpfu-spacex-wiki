package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.ExternalLinkScreen
import com.github.emilg1101.spacex.presentation.model.MissionModel
import com.github.emilg1101.spacex.presentation.model.PayloadMissionItemModel
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload.PayloadScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MissionPresenter @Inject constructor(@MissionQualifier val missionId: String) : BasePresenter<MissionView>() {

    @field:Inject
    @field:MissionQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        val model = MissionModel(
            "F3364BF",
            "Iridium NEXT",
            "Orbital ATK",
            arrayListOf(
                PayloadMissionItemModel("Iridium NEXT 1"),
                PayloadMissionItemModel("Iridium NEXT 2"),
                PayloadMissionItemModel("Iridium NEXT 3"),
                PayloadMissionItemModel("Iridium NEXT 4"),
                PayloadMissionItemModel("Iridium NEXT 5"),
                PayloadMissionItemModel("Iridium NEXT 6"),
                PayloadMissionItemModel("Iridium NEXT 7")
            ),
            "https://en.wikipedia.org/wiki/Iridium_satellite_constellation",
            "https://www.iridiumnext.com/",
            "https://twitter.com/IridiumBoss?lang=en",
            "In 2017, Iridium began launching Iridium NEXT, a second-generation worldwide network of telecommunications satellites, consisting of 66 active satellites, with another nine in-orbit spares and six on-ground spares. These satellites will incorporate features such as data transmission that were not emphasized in the original design. The constellation will provide L-band data speeds of up to 128 kbit/s to mobile terminals, up to 1.5 Mbit/s to Iridium Pilot marine terminals, and high-speed Ka-band service of up to 8 Mbit/s to fixed/transportable terminals. The next-generation terminals and service are expected to be commercially available by the end of 2018. However, Iridium's proposed use of its next-generation satellites has raised concerns the service will harmfully interfere with GPS devices. The satellites will incorporate a secondary payload for Aireon, a space-qualified ADS-B data receiver. This is for use by air traffic control and, via FlightAware, for use by airlines. A tertiary payload on 58 satellites is a marine AIS ship-tracker receiver, for Canadian company exactEarth Ltd. Iridium can also be used to provide a data link to other satellites in space, enabling command and control of other space assets regardless of the position of ground stations and gateways."
        )
        viewState.setToolbarTitle(model.name)
        viewState.showDetails(model.details)
        viewState.showManufacturers(model.manufacturers)
        viewState.showPayloads(model.payloads)
        viewState.setWikipediaLink(model.wikipedia)
        viewState.setWebsiteLink(model.website)
        viewState.setTwitterLink(model.twitter)
    }

    fun openPayload(model: PayloadMissionItemModel) {
        router.navigateTo(PayloadScreen(model.payloadId))
    }

    fun openLink(link: String) {
        router.navigateTo(ExternalLinkScreen(link))
    }
}
