package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.wiki.GetRocketsUseCase
import com.github.emilg1101.spacex.presentation.model.RocketItemModel
import com.github.emilg1101.spacex.presentation.model.RocketItemModelMapper
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets.rocket.RocketScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class RocketsPresenter @Inject constructor() : BasePresenter<RocketsView>() {

    @field:Inject
    @field:WikiQualifier
    lateinit var router: Router

    @field:Inject
    lateinit var getRocketsUseCase: GetRocketsUseCase

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Rockets")
        getRocketsUseCase.getRockets()
            .compose(PresentationSingleTransformer())
            .map(RocketItemModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({
                viewState.showRockets(it)
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
    }

    fun openRocket(model: RocketItemModel) {
        router.navigateTo(RocketScreen(model.id))
    }
}
