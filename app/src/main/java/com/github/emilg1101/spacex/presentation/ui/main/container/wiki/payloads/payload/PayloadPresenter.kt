package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.model.OrbitParamModel
import com.github.emilg1101.spacex.presentation.model.PayloadModel
import javax.inject.Inject

@InjectViewState
class PayloadPresenter @Inject constructor(@PayloadQualifier val payloadId: String) : BasePresenter<PayloadView>() {

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle(payloadId)
        val model = PayloadModel(
            "C106",
            "NASA (CRS)",
            "United States",
            "SpaceX",
            "Dragon 1.1",
            "2116",
            "false",
            arrayListOf(
                OrbitParamModel("Orbit", "ISS"),
                OrbitParamModel("Reference system", "geocentric"),
                OrbitParamModel("Regime", "low-earth"),
                OrbitParamModel("Longitude", ""),
                OrbitParamModel("Semi Major Axis", 6657.288.toString()),
                OrbitParamModel("Eccentricity", 0.0113888.toString())
            )
        )
        viewState.showSerial(model.serial)
        viewState.showCustomers(model.customers)
        viewState.showNationality(model.nationality)
        viewState.showMass(model.mass)
        viewState.showType(model.type)
        viewState.showReused(model.reused)
        viewState.showOrbitParams(model.orbitParams)
    }
}
