package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.content

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.CapsulesScreen
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.CoresScreen
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.MissionsScreen
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.PayloadsScreen
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets.RocketsScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ContentPresenter @Inject constructor() : BasePresenter<ContentView>() {

    @field:Inject
    @field:WikiQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Wiki")
    }

    fun openCapsules() {
        router.navigateTo(CapsulesScreen())
    }

    fun openMissions() {
        router.navigateTo(MissionsScreen())
    }

    fun openPayloads() {
        router.navigateTo(PayloadsScreen())
    }

    fun openCores() {
        router.navigateTo(CoresScreen())
    }

    fun openRockets() {
        router.navigateTo(RocketsScreen())
    }
}
