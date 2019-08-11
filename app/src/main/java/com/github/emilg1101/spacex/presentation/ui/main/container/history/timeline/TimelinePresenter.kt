package com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.history.GetTimelineUseCase
import com.github.emilg1101.spacex.presentation.ExternalLinkScreen
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.HistoricalEventItemModel
import com.github.emilg1101.spacex.presentation.model.HistoricalEventItemModelMapper
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import com.github.emilg1101.spacex.presentation.ui.main.container.history.HistoryQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.history.companyinfo.CompanyInfoScreen
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch.LaunchScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class TimelinePresenter @Inject constructor() : BasePresenter<TimelineView>() {

    @field:Inject
    @field:HistoryQualifier
    lateinit var router: Router

    @field:Inject
    lateinit var getTimelineUseCase: GetTimelineUseCase

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("History")
        getTimelineUseCase.getTimeline()
            .compose(PresentationSingleTransformer())
            .map(HistoricalEventItemModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({
                viewState.showEvents(it)
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
    }

    fun openLink(link: String) {
        router.navigateTo(ExternalLinkScreen(link))
    }

    fun openLaunch(model: HistoricalEventItemModel) {
        router.navigateTo(LaunchScreen(model.flightNumber))
    }

    fun openAboutCompany() {
        router.navigateTo(CompanyInfoScreen())
    }
}
