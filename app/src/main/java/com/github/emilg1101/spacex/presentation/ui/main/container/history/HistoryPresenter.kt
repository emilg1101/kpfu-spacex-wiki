package com.github.emilg1101.spacex.presentation.ui.main.container.history

import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.arellomobile.mvp.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class HistoryPresenter @Inject constructor() : BasePresenter<HistoryView>() {

    @field:HistoryQualifier
    @field:Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {

    }
}
