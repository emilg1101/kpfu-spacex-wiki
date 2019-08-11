package com.github.emilg1101.spacex.presentation.ui.main.container.history.companyinfo

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.history.GetCompanyInfoUseCase
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.CompanyInfoModelMapper
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import javax.inject.Inject

@InjectViewState
class CompanyInfoPresenter @Inject constructor() : BasePresenter<CompanyInfoView>() {

    @field:Inject
    lateinit var getCompanyInfoUseCase: GetCompanyInfoUseCase

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("About SpaceX")
        getCompanyInfoUseCase.getCompanyInfo()
            .compose(PresentationSingleTransformer())
            .map(CompanyInfoModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({ model ->
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
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
    }
}
