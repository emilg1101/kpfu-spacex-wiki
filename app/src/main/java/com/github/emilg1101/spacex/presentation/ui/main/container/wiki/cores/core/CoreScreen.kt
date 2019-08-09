package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.core

import ru.terrakok.cicerone.android.support.SupportAppScreen

class CoreScreen(private val serial: String) : SupportAppScreen() {

    override fun getScreenKey() = CoreFragment.TAG

    override fun getFragment() = CoreFragment.newInstance(serial)
}
