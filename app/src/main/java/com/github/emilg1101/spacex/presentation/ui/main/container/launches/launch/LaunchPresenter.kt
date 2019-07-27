package com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch

import com.arellomobile.mvp.InjectViewState
import com.github.emilg1101.spacex.presentation.base.BasePresenter
import com.github.emilg1101.spacex.presentation.model.CoreLaunchItemModel
import com.github.emilg1101.spacex.presentation.model.LinkLaunchItemModel
import com.github.emilg1101.spacex.presentation.model.PayloadLaunchItemModel
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.LaunchesQualifier
import com.yandex.mapkit.geometry.Point
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class LaunchPresenter @Inject constructor() : BasePresenter<LaunchView>() {

    @field:Inject
    @field:LaunchesQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        viewState.setToolbarTitle("Launch")
        viewState.showCores(
            arrayListOf(
                CoreLaunchItemModel("B1057.1", "OCISLY", "ASDS", true, false),
                CoreLaunchItemModel("B1057.1", "OCISLY", "ASDS", true, false)
            )
        )
        viewState.showPayloads(
            arrayListOf(
                PayloadLaunchItemModel("Starlink 2"),
                PayloadLaunchItemModel("Starlink 2")
            )
        )
        viewState.showLaunchPadOnMap(Point(34.632093, -120.610829))
        viewState.showLinks(
            arrayListOf(
                LinkLaunchItemModel("Wikipedia", ""),
                LinkLaunchItemModel("Reddit", "")
            )
        )
        /*viewState.showImages(
            arrayListOf(
                "https://farm5.staticflickr.com/4866/39745612523_14270b4b9d_o.jpg",
                "https://farm8.staticflickr.com/7833/39745612923_21aa442350_o.jpg",
                "https://farm5.staticflickr.com/4881/39745613173_e99b09c000_o.jpg",
                "https://farm8.staticflickr.com/7882/39745613513_6cdd4581af_o.jpg",
                "https://farm8.staticflickr.com/7807/39745613733_1a7b70e54a_o.jpg",
                "https://farm5.staticflickr.com/4891/39745614053_43855205bc_o.jpg"
            )
        )*/
    }

    fun openRocket() {

    }

    fun openCore(core: CoreLaunchItemModel) {

    }

    fun openPayload(payload: PayloadLaunchItemModel) {

    }

    fun openLink(link: LinkLaunchItemModel) {

    }
}
