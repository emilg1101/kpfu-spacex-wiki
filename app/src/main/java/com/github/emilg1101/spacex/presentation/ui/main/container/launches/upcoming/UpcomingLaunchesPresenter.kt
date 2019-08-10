package com.github.emilg1101.spacex.presentation.ui.main.container.launches.upcoming

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.launch.GetUpcomingLaunchesUseCase
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.UpcomingLaunchItemModel
import com.github.emilg1101.spacex.presentation.model.UpcomingLaunchItemModelMapper
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.LaunchesQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class UpcomingLaunchesPresenter @Inject constructor() : BasePresenter<UpcomingLaunchesView>() {

    @field:Inject
    @field:LaunchesQualifier
    lateinit var router: Router

    @field:Inject
    lateinit var getUpcomingLaunchesUseCase: GetUpcomingLaunchesUseCase

    override fun onFirstViewAttach() {
        getUpcomingLaunchesUseCase.getLaunches()
            .compose(PresentationSingleTransformer())
            .map(UpcomingLaunchItemModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({
                viewState.setLaunches(it)
            }, {
                it.printStackTrace()
            })
            .disposeWhenDestroy()
    }

    fun openLaunch(model: UpcomingLaunchItemModel) {
        router.navigateTo(LaunchScreen(model.flightNumber))
    }
}
