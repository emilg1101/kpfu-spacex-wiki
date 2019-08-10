package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.capsule

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.emilg1101.spacex.presentation.base.BaseView
import com.github.emilg1101.spacex.presentation.base.HasProgressBar
import com.github.emilg1101.spacex.presentation.model.MissionItemShortModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface CapsuleView : BaseView, HasProgressBar {

    fun showDetails(details: String)

    fun showStatus(status: String)

    fun showLaunchTime(launchTime: String)

    fun showLandings(landings: String)

    fun showType(type: String)

    fun showReuseCount(reuseCount: String)

    fun showMissions(items: List<MissionItemShortModel>)
}
