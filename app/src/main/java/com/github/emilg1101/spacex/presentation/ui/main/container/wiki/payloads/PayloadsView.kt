package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads

import com.github.emilg1101.spacex.presentation.base.BaseView
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.github.emilg1101.spacex.presentation.model.PayloadItemModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface PayloadsView : BaseView {

    fun showPayloads(items: List<PayloadItemModel>)
}
