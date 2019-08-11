package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.wiki.GetCapsulesUseCase
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.CapsuleItemModel
import com.github.emilg1101.spacex.presentation.model.CapsuleItemModelMapper
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.capsule.CapsuleScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class CapsulesPresenter @Inject constructor() : BasePresenter<CapsulesView>() {

    @field:Inject
    @field:WikiQualifier
    lateinit var router: Router

    @field:Inject
    lateinit var getCapsulesUseCase: GetCapsulesUseCase

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Capsules")
        getCapsulesUseCase.getCapsules()
            .compose(PresentationSingleTransformer())
            .map(CapsuleItemModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({
                viewState.showCapsules(it)
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
    }

    fun openCapsule(model: CapsuleItemModel) {
        router.navigateTo(CapsuleScreen(model.serial))
    }
}
