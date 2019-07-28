package com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.emilg1101.spacex.presentation.base.BaseView
import com.github.emilg1101.spacex.presentation.model.CoreLaunchItemModel
import com.github.emilg1101.spacex.presentation.model.LinkLaunchItemModel
import com.github.emilg1101.spacex.presentation.model.PayloadLaunchItemModel
import com.yandex.mapkit.geometry.Point

@StateStrategyType(AddToEndSingleStrategy::class)
interface LaunchView : BaseView {

    fun showMission(name: String)

    fun showLaunchPad(name: String)

    fun showLaunchTime(time: String)

    fun showDetails(details: String)

    fun showRocket(name: String)

    fun showPatch(patch: String)

    fun showLaunchPadOnMap(point: Point)

    fun showCores(items: List<CoreLaunchItemModel>)

    fun showPayloads(items: List<PayloadLaunchItemModel>)

    fun showLinks(items: List<LinkLaunchItemModel>)

    fun showImages(items: List<String>)

    fun setRocketId(id: String)

    fun setLaunchPadId(id: String)

    fun showRemind()
}
