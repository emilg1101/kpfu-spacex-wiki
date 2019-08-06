package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.model.PayloadItemModel
import javax.inject.Inject

@InjectViewState
class PayloadsPresenter @Inject constructor() : BasePresenter<PayloadsView>() {

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Payloads")
        viewState.showPayloads(arrayListOf(
            PayloadItemModel("SpaceX CRS-2", "SpaceX", "United States"),
            PayloadItemModel("SpaceX CRS-2", "SpaceX", "United States"),
            PayloadItemModel("SpaceX CRS-2", "SpaceX", "United States"),
            PayloadItemModel("SpaceX CRS-2", "SpaceX", "United States"),
            PayloadItemModel("SpaceX CRS-2", "SpaceX", "United States"),
            PayloadItemModel("SpaceX CRS-2", "SpaceX", "United States"),
            PayloadItemModel("SpaceX CRS-2", "SpaceX", "United States"),
            PayloadItemModel("SpaceX CRS-2", "SpaceX", "United States"),
            PayloadItemModel("SpaceX CRS-2", "SpaceX", "United States"),
            PayloadItemModel("SpaceX CRS-2", "SpaceX", "United States")
        ))
    }

    fun openPayload(model: PayloadItemModel) {

    }
}
