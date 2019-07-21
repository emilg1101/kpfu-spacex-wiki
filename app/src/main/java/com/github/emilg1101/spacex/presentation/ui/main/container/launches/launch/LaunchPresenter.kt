package com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.LaunchesQualifier
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class LaunchPresenter @Inject constructor() : BasePresenter<LaunchView>() {

    @field:Inject
    @field:LaunchesQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Launch")
    }
}
