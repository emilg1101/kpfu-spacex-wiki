package com.github.emilg1101.spacex.presentation.ui.main.container.launches

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.container.LaunchesContainerScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class LaunchesPresenter @Inject constructor() : BasePresenter<LaunchesView>() {

    @field:LaunchesQualifier
    @field:Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        router.newRootScreen(LaunchesContainerScreen())
    }
}
