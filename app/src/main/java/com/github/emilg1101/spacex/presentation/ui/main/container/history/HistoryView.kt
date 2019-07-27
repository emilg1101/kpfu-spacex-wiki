package com.github.emilg1101.spacex.presentation.ui.main.container.history

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.emilg1101.spacex.presentation.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface HistoryView : BaseView {

}
