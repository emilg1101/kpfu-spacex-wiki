package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets

import com.github.emilg1101.spacex.presentation.base.BaseView
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.github.emilg1101.spacex.presentation.base.HasProgressBar
import com.github.emilg1101.spacex.presentation.model.RocketItemModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface RocketsView : BaseView, HasProgressBar {

    fun showRockets(items: List<RocketItemModel>)
}
