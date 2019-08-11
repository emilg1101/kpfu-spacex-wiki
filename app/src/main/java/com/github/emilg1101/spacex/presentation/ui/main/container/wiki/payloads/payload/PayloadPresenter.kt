package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.wiki.GetPayloadUseCase
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.PayloadModelMapper
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import javax.inject.Inject

@InjectViewState
class PayloadPresenter @Inject constructor(@PayloadQualifier val payloadId: String) : BasePresenter<PayloadView>() {

    @field:Inject
    lateinit var getPayloadUseCase: GetPayloadUseCase

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle(payloadId)
        getPayloadUseCase.getPayload(payloadId)
            .compose(PresentationSingleTransformer())
            .map(PayloadModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({ model ->
                viewState.showSerial(model.serial)
                viewState.showCustomers(model.customers)
                viewState.showNationality(model.nationality)
                viewState.showManufacturer(model.manufacturer)
                viewState.showMass(model.mass)
                viewState.showType(model.type)
                viewState.showReused(model.reused)
                viewState.showOrbitParams(model.orbitParams)
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
    }
}
