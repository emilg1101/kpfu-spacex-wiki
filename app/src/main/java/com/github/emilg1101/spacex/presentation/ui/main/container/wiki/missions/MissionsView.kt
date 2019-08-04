package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions

import com.github.emilg1101.spacex.presentation.base.BaseView
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.github.emilg1101.spacex.presentation.model.MissionItemModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface MissionsView : BaseView {

    fun showMissions(items: List<MissionItemModel>)
}
