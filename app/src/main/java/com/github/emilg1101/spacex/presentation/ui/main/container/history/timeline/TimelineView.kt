package com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.emilg1101.spacex.presentation.base.BaseView
import com.github.emilg1101.spacex.presentation.base.HasProgressBar
import com.github.emilg1101.spacex.presentation.model.HistoricalEventItemModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface TimelineView : BaseView, HasProgressBar {

    fun showEvents(items: List<HistoricalEventItemModel>)
}
