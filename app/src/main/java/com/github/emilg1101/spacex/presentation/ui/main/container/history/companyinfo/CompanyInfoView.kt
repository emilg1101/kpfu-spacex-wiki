package com.github.emilg1101.spacex.presentation.ui.main.container.history.companyinfo

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.emilg1101.spacex.presentation.base.BaseView
import com.github.emilg1101.spacex.presentation.base.HasProgressBar

@StateStrategyType(AddToEndSingleStrategy::class)
interface CompanyInfoView : BaseView, HasProgressBar {

    fun showSummary(summary: String)

    fun showFounder(founder: String)

    fun showCEO(ceo: String)

    fun showCOO(coo: String)

    fun showCTO(cto: String)

    fun showCTOPropulsion(ctoPropulsion: String)

    fun showState(state: String)

    fun showCity(city: String)

    fun showAddress(address: String)

    fun showEmployees(employees: String)

    fun showVehicles(vehicles: String)

    fun showLaunchSites(launchSites: String)

    fun showValuation(valuation: String)
}
