package com.github.emilg1101.spacex.presentation.ui.main.container.wiki

import com.github.emilg1101.spacex.presentation.base.BaseView
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy

@StateStrategyType(AddToEndSingleStrategy::class)
interface WikiView : BaseView {

}
