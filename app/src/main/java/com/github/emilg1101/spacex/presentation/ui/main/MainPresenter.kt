package com.github.emilg1101.spacex.presentation.ui.main

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.ui.main.container.BottomMainContainerScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor() : BasePresenter<MainView>() {

    @field:MainQualifier
    @field:Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        router.newRootScreen(BottomMainContainerScreen())
    }
}
