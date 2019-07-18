package com.github.emilg1101.spacex.presentation.ui.main.container

import com.github.emilg1101.spacex.presentation.base.BaseView
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import java.text.FieldPosition

@StateStrategyType(AddToEndSingleStrategy::class)
interface BottomMainContainerView : BaseView {

    fun swipePage(position: Int)
}
