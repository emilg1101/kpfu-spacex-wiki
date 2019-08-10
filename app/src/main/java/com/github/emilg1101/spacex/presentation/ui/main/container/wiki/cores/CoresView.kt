package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores

import com.github.emilg1101.spacex.presentation.base.BaseView
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.github.emilg1101.spacex.presentation.base.HasProgressBar
import com.github.emilg1101.spacex.presentation.model.CoreItemModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface CoresView : BaseView, HasProgressBar {

    fun showCores(items: List<CoreItemModel>)
}
