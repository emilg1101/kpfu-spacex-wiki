package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload

import com.github.emilg1101.spacex.presentation.base.BaseView
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.github.emilg1101.spacex.presentation.base.HasProgressBar
import com.github.emilg1101.spacex.presentation.model.OrbitParamModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface PayloadView : BaseView, HasProgressBar {

    fun showSerial(serial: String)

    fun showCustomers(customers: String)

    fun showNationality(nationality: String)

    fun showManufacturer(manufacturer: String)

    fun showMass(mass: String)

    fun showType(type: String)

    fun showReused(reused: String)

    fun showOrbitParams(items: List<OrbitParamModel>)
}
