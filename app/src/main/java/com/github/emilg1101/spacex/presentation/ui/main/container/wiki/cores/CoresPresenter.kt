package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.CoreItemModel
import javax.inject.Inject

@InjectViewState
class CoresPresenter @Inject constructor() : BasePresenter<CoresView>() {

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Cores")
        viewState.showCores(arrayListOf(
            CoreItemModel("Merlin1A"),
            CoreItemModel("Merlin1A"),
            CoreItemModel("Merlin1A"),
            CoreItemModel("Merlin1A"),
            CoreItemModel("Merlin1A"),
            CoreItemModel("Merlin1A"),
            CoreItemModel("Merlin1A"),
            CoreItemModel("Merlin1A"),
            CoreItemModel("Merlin1A"),
            CoreItemModel("Merlin1A")
        ))
    }

    fun openCore(model: CoreItemModel) {

    }
}
