package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets

import ru.terrakok.cicerone.android.support.SupportAppScreen

class RocketsScreen : SupportAppScreen() {

    override fun getScreenKey() = RocketsFragment.TAG

    override fun getFragment() = RocketsFragment.newInstance()
}
