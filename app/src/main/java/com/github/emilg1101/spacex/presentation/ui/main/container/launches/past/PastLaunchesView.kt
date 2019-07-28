package com.github.emilg1101.spacex.presentation.ui.main.container.launches.past

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.emilg1101.spacex.presentation.base.BaseView
import com.github.emilg1101.spacex.presentation.model.PastLaunchItemModel

interface PastLaunchesView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setLaunches(items: List<PastLaunchItemModel>)
}
