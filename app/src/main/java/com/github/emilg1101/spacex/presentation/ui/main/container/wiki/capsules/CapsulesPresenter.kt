package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import javax.inject.Inject

@InjectViewState
class CapsulesPresenter @Inject constructor() : BasePresenter<CapsulesView>() {

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Capsules")
    }
}
