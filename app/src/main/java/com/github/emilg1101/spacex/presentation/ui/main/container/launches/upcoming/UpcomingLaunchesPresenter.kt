package com.github.emilg1101.spacex.presentation.ui.main.container.launches.upcoming

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.UpcomingLaunchItemModel
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.LaunchesQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class UpcomingLaunchesPresenter @Inject constructor() : BasePresenter<UpcomingLaunchesView>() {

    @field:Inject
    @field:LaunchesQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        viewState.setLaunches(arrayListOf(
                UpcomingLaunchItemModel("", "Nusantara Satu (PSN-6) / GTO-1 / Beresheet", "2019-02-22T01:45:00.000Z", "2019-02-22T01:45:00.000Z", 75)
        ))
    }

    fun openLaunch(flightNumber: Int) {
        router.navigateTo(LaunchScreen(flightNumber))
    }
}
