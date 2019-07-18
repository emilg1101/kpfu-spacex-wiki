package com.github.emilg1101.spacex.presentation.ui.main.container

import ru.terrakok.cicerone.android.support.SupportAppScreen

class BottomMainContainerScreen : SupportAppScreen() {

    override fun getScreenKey() = BottomMainContainerFragment.TAG

    override fun getFragment() = BottomMainContainerFragment.newInstance()
}
