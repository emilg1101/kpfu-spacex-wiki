package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.model.RocketItemModel
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets.rocket.RocketScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class RocketsPresenter @Inject constructor() : BasePresenter<RocketsView>() {

    @field:Inject
    @field:WikiQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Rockets")
        viewState.showRockets(
            arrayListOf(
                RocketItemModel(
                    "falcon1",
                    "Falcon 1",
                    "The Falcon 1 was an expendable launch system privately developed and manufactured by SpaceX during 2006-2009. On 28 September 2008, Falcon 1 became the first privately-developed liquid-fuel launch vehicle to go into orbit around the Earth."
                ),
                RocketItemModel(
                    "falcon1",
                    "Falcon 1",
                    "The Falcon 1 was an expendable launch system privately developed and manufactured by SpaceX during 2006-2009. On 28 September 2008, Falcon 1 became the first privately-developed liquid-fuel launch vehicle to go into orbit around the Earth."
                ),
                RocketItemModel(
                    "falcon1",
                    "Falcon 1",
                    "The Falcon 1 was an expendable launch system privately developed and manufactured by SpaceX during 2006-2009. On 28 September 2008, Falcon 1 became the first privately-developed liquid-fuel launch vehicle to go into orbit around the Earth."
                ),
                RocketItemModel(
                    "falcon1",
                    "Falcon 1",
                    "The Falcon 1 was an expendable launch system privately developed and manufactured by SpaceX during 2006-2009. On 28 September 2008, Falcon 1 became the first privately-developed liquid-fuel launch vehicle to go into orbit around the Earth."
                ),
                RocketItemModel(
                    "falcon1",
                    "Falcon 1",
                    "The Falcon 1 was an expendable launch system privately developed and manufactured by SpaceX during 2006-2009. On 28 September 2008, Falcon 1 became the first privately-developed liquid-fuel launch vehicle to go into orbit around the Earth."
                )
            )
        )
    }

    fun openRocket(model: RocketItemModel) {
        router.navigateTo(RocketScreen(model.id))
    }
}
