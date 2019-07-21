package com.github.emilg1101.spacex.presentation.ui.main.container.launches.past

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.PastLaunchItemModel
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.LaunchesQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class PastLaunchesPresenter @Inject constructor() : BasePresenter<PastLaunchesView>() {

    @field:Inject
    @field:LaunchesQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        viewState.setLaunches(arrayListOf(
                PastLaunchItemModel("", "Nusantara Satu (PSN-6) / GTO-1 / Beresheet", "2019-02-22T01:45:00.000Z", 75)
        ))
    }

    fun openLaunch(flightNumber: Int) {
        router.navigateTo(LaunchScreen(flightNumber))
    }
}
