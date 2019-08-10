package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.core

import com.github.emilg1101.spacex.presentation.base.BaseView
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.github.emilg1101.spacex.presentation.base.HasProgressBar
import com.github.emilg1101.spacex.presentation.model.MissionItemShortModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface CoreView : BaseView, HasProgressBar {

    fun showBlock(block: String)

    fun showStatus(status: String)

    fun showLaunchTime(launchTime: String)

    fun showDetails(details: String)

    fun showReuseCount(reuseCount: Int)

    fun showRtlsAttempts(rtlsAttempts: Int)

    fun showRtlsLandings(rtlsLandings: Int)

    fun showAsdsAttempts(asdsAttempts: Int)

    fun showAsdsLandings(asdsLandings: Int)

    fun showWaterLanding(waterLanding: String)

    fun showMissions(items: List<MissionItemShortModel>)
}
