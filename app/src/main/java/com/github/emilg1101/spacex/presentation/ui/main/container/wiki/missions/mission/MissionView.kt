package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission

import com.github.emilg1101.spacex.presentation.base.BaseView
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.github.emilg1101.spacex.presentation.base.HasProgressBar
import com.github.emilg1101.spacex.presentation.model.PayloadMissionItemModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface MissionView : BaseView, HasProgressBar {

    fun showDetails(details: String)

    fun showManufacturers(manufacturers: String)

    fun showPayloads(items: List<PayloadMissionItemModel>)

    fun setWikipediaLink(link: String)

    fun setWebsiteLink(link: String)

    fun setTwitterLink(link: String)
}
