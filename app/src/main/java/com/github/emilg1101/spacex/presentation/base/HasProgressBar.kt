package com.github.emilg1101.spacex.presentation.base

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface HasProgressBar: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProgressBar()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun hideProgressBar()
}