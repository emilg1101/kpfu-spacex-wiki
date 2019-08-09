package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores

import ru.terrakok.cicerone.android.support.SupportAppScreen

class CoresScreen : SupportAppScreen() {

    override fun getScreenKey() = CoresFragment.TAG

    override fun getFragment() = CoresFragment.newInstance()
}
