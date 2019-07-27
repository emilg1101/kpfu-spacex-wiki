package com.github.emilg1101.spacex.presentation.ui.main.container.wiki

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.content.ContentScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class WikiPresenter @Inject constructor() : BasePresenter<WikiView>() {

    @field:WikiQualifier
    @field:Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        router.newRootScreen(ContentScreen())
    }
}
