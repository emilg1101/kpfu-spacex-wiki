package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.CoreItemModel
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.core.CoreScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class CoresPresenter @Inject constructor() : BasePresenter<CoresView>() {

    @field:Inject
    @field:WikiQualifier
    lateinit var router: Router

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
        router.navigateTo(CoreScreen(model.serial))
    }
}
