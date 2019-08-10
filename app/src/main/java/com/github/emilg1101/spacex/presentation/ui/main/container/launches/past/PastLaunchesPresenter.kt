package com.github.emilg1101.spacex.presentation.ui.main.container.launches.past

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.launch.GetPastLaunchesUseCase
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.PastLaunchItemModel
import com.github.emilg1101.spacex.presentation.model.PastLaunchItemModelMapper
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.LaunchesQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class PastLaunchesPresenter @Inject constructor() : BasePresenter<PastLaunchesView>() {

    @field:Inject
    @field:LaunchesQualifier
    lateinit var router: Router

    @field:Inject
    lateinit var getPastLaunchesUseCase: GetPastLaunchesUseCase

    override fun onFirstViewAttach() {
        getPastLaunchesUseCase.getLaunches()
            .compose(PresentationSingleTransformer())
            .map(PastLaunchItemModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({
                viewState.setLaunches(it)
            }, {
                it.printStackTrace()
            })
            .disposeWhenDestroy()
    }

    fun openLaunch(model: PastLaunchItemModel) {
        router.navigateTo(LaunchScreen(model.flightNumber))
    }
}
