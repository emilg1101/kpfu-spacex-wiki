package com.github.emilg1101.spacex.presentation.base

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface BaseView: MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun setToolbarTitle(text: String)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun setToolbarTitle(text: Int)
}
