package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.domain.usecase.wiki.GetPayloadsUseCase
import com.github.emilg1101.spacex.presentation.model.PayloadItemModel
import com.github.emilg1101.spacex.presentation.model.PayloadItemModelMapper
import com.github.emilg1101.spacex.presentation.rx.transformer.PresentationSingleTransformer
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload.PayloadScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class PayloadsPresenter @Inject constructor() : BasePresenter<PayloadsView>() {

    @field:Inject
    @field:WikiQualifier
    lateinit var router: Router

    @field:Inject
    lateinit var getPayloadsUseCase: GetPayloadsUseCase

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Payloads")
        getPayloadsUseCase.getPayloads()
            .compose(PresentationSingleTransformer())
            .map(PayloadItemModelMapper::map)
            .doOnSubscribe { viewState.showProgressBar() }
            .doAfterSuccess { viewState.hideProgressBar() }
            .subscribe({
                viewState.showPayloads(it)
            }, {
                it.printStackTrace()
            }).disposeWhenDestroy()
    }

    fun openPayload(model: PayloadItemModel) {
        router.navigateTo(PayloadScreen(model.id))
    }
}
