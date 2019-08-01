package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.CapsuleItemModel
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiQualifier
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.capsule.CapsuleScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class CapsulesPresenter @Inject constructor() : BasePresenter<CapsulesView>() {

    @field:Inject
    @field:WikiQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Capsules")
        viewState.showCapsules(arrayListOf(
            CapsuleItemModel("C101", "retired", "Dragon 1.0"),
            CapsuleItemModel("C102", "retired", "Dragon 1.0"),
            CapsuleItemModel("C103", "retired", "Dragon 1.0"),
            CapsuleItemModel("C104", "retired", "Dragon 1.0"),
            CapsuleItemModel("C105", "active", "Dragon 1.0"),
            CapsuleItemModel("C106", "active", "Dragon 1.0"),
            CapsuleItemModel("C107", "active", "Dragon 1.1"),
            CapsuleItemModel("C108", "active", "Dragon 2.0")
        ))
    }

    fun openCapsule(model: CapsuleItemModel) {
        router.navigateTo(CapsuleScreen(model.serial))
    }
}
