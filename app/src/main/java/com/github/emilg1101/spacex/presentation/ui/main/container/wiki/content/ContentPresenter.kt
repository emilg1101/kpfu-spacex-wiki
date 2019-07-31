package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.content

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiQualifier
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

    }

    fun openMissions() {

    }

    fun openPayloads() {

    }

    fun openCores() {

    }

    fun openRockets() {

    }
}
