package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.wiki.GetCoresUseCase
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.CoreItemModel
import com.github.emilg1101.spacex.presentation.model.CoreItemModelMapper
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.core.CoreScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class CoresPresenter @Inject constructor() : BasePresenter<CoresView>() {

    @field:Inject
    @field:WikiQualifier
    lateinit var router: Router

    @field:Inject
    lateinit var getCoresUseCase: GetCoresUseCase

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Cores")
        getCoresUseCase.getCores()
            .compose(PresentationSingleTransformer())
            .map(CoreItemModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({
                viewState.showCores(it)
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
    }

    fun openCore(model: CoreItemModel) {
        router.navigateTo(CoreScreen(model.serial))
    }
}
