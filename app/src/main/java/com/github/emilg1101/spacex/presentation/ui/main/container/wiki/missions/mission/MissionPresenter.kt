package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.wiki.GetMissionUseCase
import com.github.emilg1101.spacex.presentation.ExternalLinkScreen
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.MissionModelMapper
import com.github.emilg1101.spacex.presentation.model.PayloadMissionItemModel
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload.PayloadScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MissionPresenter @Inject constructor(@MissionQualifier val missionId: String) : BasePresenter<MissionView>() {

    @field:Inject
    @field:MissionQualifier
    lateinit var router: Router

    @field:Inject
    lateinit var getMissionUseCase: GetMissionUseCase

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Mission")
        getMissionUseCase.getMission(missionId)
            .compose(PresentationSingleTransformer())
            .map(MissionModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterTerminate { viewState.hideProgressBar() }
            .subscribe({ model ->
                viewState.setToolbarTitle(model.name)
                viewState.showDetails(model.details)
                viewState.showManufacturers(model.manufacturers)
                viewState.showPayloads(model.payloads)
                viewState.setWikipediaLink(model.wikipedia)
                viewState.setWebsiteLink(model.website)
                viewState.setTwitterLink(model.twitter)
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
    }

    fun openPayload(model: PayloadMissionItemModel) {
        router.navigateTo(PayloadScreen(model.payloadId))
    }

    fun openLink(link: String) {
        router.navigateTo(ExternalLinkScreen(link))
    }
}
