package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets.rocket

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.wiki.GetRocketUseCase
import com.github.emilg1101.spacex.presentation.ExternalLinkScreen
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.RocketModelMapper
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class RocketPresenter @Inject constructor(@RocketQualifier private val rocketId: String) : BasePresenter<RocketView>() {

    @field:Inject
    @field:RocketQualifier
    lateinit var router: Router

    @field:Inject
    lateinit var getRocketUseCase: GetRocketUseCase

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Rocket")
        getRocketUseCase.getRocket(rocketId)
            .compose(PresentationSingleTransformer())
            .map(RocketModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({ model ->
                viewState.setToolbarTitle(model.name)
                viewState.showFirstFlight(model.firstFlight)
                viewState.showDescription(model.description)
                viewState.showCostPerLaunch(model.costPerLaunch)
                viewState.showCountry(model.country)
                viewState.showCompany(model.company)
                viewState.showEngine(model.engine)
                viewState.showStages(model.stages)
                viewState.showBoosters(model.boosters)
                viewState.showSuccessRate(model.successRate)
                viewState.showHeight(model.height)
                viewState.showDiameter(model.diameter)
                viewState.showMass(model.mass)
                viewState.setWikipediaLink(model.wikipedia)
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
    }

    fun openLink(link: String) {
        router.navigateTo(ExternalLinkScreen(link))
    }
}
