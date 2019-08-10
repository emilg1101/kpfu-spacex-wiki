package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.emilg1101.spacex.presentation.base.BaseView
import com.github.emilg1101.spacex.presentation.base.HasProgressBar
import com.github.emilg1101.spacex.presentation.model.CapsuleItemModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface CapsulesView : BaseView, HasProgressBar {

    fun showCapsules(items: List<CapsuleItemModel>)
}
