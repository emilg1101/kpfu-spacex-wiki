package com.github.emilg1101.spacex.presentation.ui.main.container.history.companyinfo

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.CompanyInfoModel
import javax.inject.Inject

@InjectViewState
class CompanyInfoPresenter @Inject constructor() : BasePresenter<CompanyInfoView>() {

    override fun onFirstViewAttach() {
        val model = CompanyInfoModel(
            "Elon Musk",
            "7000",
            "3",
            "3",
            "Elon Musk",
            "Elon Musk",
            "Gwynne Shotwell",
            "Tom Mueller",
            "15000000000$",
            "Rocket Road",
            "Hawthorne",
            "California",
            "SpaceX designs, manufactures and launches advanced rockets and spacecraft. The company was founded in 2002 to revolutionize space technology, with the ultimate goal of enabling people to live on other planets."
        )
        viewState.setToolbarTitle("About SpaceX")
        viewState.showSummary(model.summary)
        viewState.showFounder(model.founder)
        viewState.showCEO(model.ceo)
        viewState.showCOO(model.coo)
        viewState.showCTO(model.cto)
        viewState.showCTOPropulsion(model.ctoPropulsion)
        viewState.showState(model.headquartersState)
        viewState.showCity(model.headquartersCity)
        viewState.showAddress(model.headquartersAddress)
        viewState.showEmployees(model.employees)
        viewState.showVehicles(model.vehicles)
        viewState.showLaunchSites(model.launchSites)
        viewState.showValuation(model.valuation)
    }
}
