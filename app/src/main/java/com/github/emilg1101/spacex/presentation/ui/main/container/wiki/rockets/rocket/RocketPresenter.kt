package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets.rocket

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.ExternalLinkScreen
import com.github.emilg1101.spacex.presentation.model.RocketModel
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class RocketPresenter @Inject constructor(@RocketQualifier private val rocketId: String) : BasePresenter<RocketView>() {

    @field:Inject
    @field:RocketQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle(rocketId)
        val model = RocketModel(
            "Falcon 1",
            "false",
            "6700000",
            "2006-03-24",
            "Republic of the Marshall Islands",
            "SpaceX",
            "2",
            "0",
            "40",
            "22.25",
            "1.68",
            "30146",
            "merlin",
            "https://en.wikipedia.org/wiki/Falcon_1",
            "The Falcon 1 was an expendable launch system privately developed and manufactured by SpaceX during 2006-2009. On 28 September 2008, Falcon 1 became the first privately-developed liquid-fuel launch vehicle to go into orbit around the Earth."
        )
        viewState.showFirstFlight(model.firstFlight)
        viewState.showDescription(model.description)
        viewState.showCostPerLaunch(model.costPerLaunch)
        viewState.showCountry(model.country)
        viewState.showCompany(model.company)
        viewState.showEngine(model.engine)
        viewState.showStages(model.stages)
        viewState.showBoosters(model.boosters)
        viewState.showSuccessRate(model.successRate)
        viewState.showHeight(model.height)
        viewState.showDiameter(model.diameter)
        viewState.showMass(model.mass)
        viewState.setWikipediaLink(model.wikipedia)
    }

    fun openLink(link: String) {
        router.navigateTo(ExternalLinkScreen(link))
    }
}
