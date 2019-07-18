package com.github.emilg1101.spacex.presentation.ui.main.container

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import javax.inject.Inject

@InjectViewState
class BottomMainContainerPresenter @Inject constructor() : BasePresenter<BottomMainContainerView>() {

    fun onNavigationItemClick(position: Int) {
        viewState.swipePage(position)
    }
}
