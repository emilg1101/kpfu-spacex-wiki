package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules

import ru.terrakok.cicerone.android.support.SupportAppScreen

class CapsulesScreen : SupportAppScreen() {

    override fun getScreenKey() = CapsulesFragment.TAG

    override fun getFragment() = CapsulesFragment.newInstance()
}
