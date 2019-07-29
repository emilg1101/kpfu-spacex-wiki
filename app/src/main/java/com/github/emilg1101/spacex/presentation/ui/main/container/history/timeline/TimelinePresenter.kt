package com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.ExternalLinkScreen
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.HistoricalEventItemModel
import com.github.emilg1101.spacex.presentation.ui.main.container.history.HistoryQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class TimelinePresenter @Inject constructor() : BasePresenter<TimelineView>() {

    @field:Inject
    @field:HistoryQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("History")
        viewState.showEvents(
            arrayListOf(
                HistoricalEventItemModel(
                    "Falcon 1 Makes History",
                    "Falcon 1 becomes the first privately developed liquid fuel rocket to reach Earth orbit.",
                    "2008-09-28",
                    "",
                    "http://www.spacex.com/news/2013/02/11/flight-4-launch-update-0",
                    "https://en.wikipedia.org/wiki/Falcon_1",
                    0
                ),
                HistoricalEventItemModel(
                    "Falcon 1 Makes History",
                    "Falcon 1 becomes the first privately developed liquid fuel rocket to reach Earth orbit.",
                    "2008-09-28",
                    "",
                    "http://www.spacex.com/news/2013/02/11/flight-4-launch-update-0",
                    "https://en.wikipedia.org/wiki/Falcon_1",
                    0
                ),
                HistoricalEventItemModel(
                    "Falcon 1 Makes History",
                    "Falcon 1 becomes the first privately developed liquid fuel rocket to reach Earth orbit.",
                    "2008-09-28",
                    "",
                    "",
                    "https://en.wikipedia.org/wiki/Falcon_1",
                    0
                ),
                HistoricalEventItemModel(
                    "Falcon 1 Makes History",
                    "Falcon 1 becomes the first privately developed liquid fuel rocket to reach Earth orbit.",
                    "2008-09-28",
                    "http://www.spacex.com/news/2013/02/11/flight-4-launch-update-0",
                    "http://www.spacex.com/news/2013/02/11/flight-4-launch-update-0",
                    "https://en.wikipedia.org/wiki/Falcon_1",
                    0
                )
            )
        )
    }

    fun openLink(link: String) {
        router.navigateTo(ExternalLinkScreen(link))
    }

    fun openLaunch(model: HistoricalEventItemModel) {
        router.navigateTo(LaunchScreen(model.flightNumber))
    }
}
