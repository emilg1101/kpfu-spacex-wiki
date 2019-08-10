package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets.rocket

import com.github.emilg1101.spacex.presentation.base.BaseView
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.github.emilg1101.spacex.presentation.base.HasProgressBar

@StateStrategyType(AddToEndSingleStrategy::class)
interface RocketView : BaseView, HasProgressBar {

    fun showFirstFlight(firstFlight: String)

    fun showDescription(description: String)

    fun showCostPerLaunch(costPerLaunch: String)

    fun showCountry(country: String)

    fun showCompany(company: String)

    fun showEngine(engine: String)

    fun showStages(stages: String)

    fun showBoosters(boosters: String)

    fun showSuccessRate(successRate: String)

    fun showHeight(height: String)

    fun showDiameter(diameter: String)

    fun showMass(mass: String)

    fun setWikipediaLink(link: String)
}
