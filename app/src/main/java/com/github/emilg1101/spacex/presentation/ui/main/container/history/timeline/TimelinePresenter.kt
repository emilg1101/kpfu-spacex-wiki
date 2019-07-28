package com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class TimelinePresenter @Inject constructor() : BasePresenter<TimelineView>() {

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("History")
    }
}
