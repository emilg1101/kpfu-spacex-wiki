package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets.rocket

import ru.terrakok.cicerone.android.support.SupportAppScreen

class RocketScreen(private val rocketId: String) : SupportAppScreen() {

    override fun getScreenKey() = RocketFragment.TAG

    override fun getFragment() = RocketFragment.newInstance(rocketId)
}
