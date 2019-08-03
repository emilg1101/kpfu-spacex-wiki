package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions

import ru.terrakok.cicerone.android.support.SupportAppScreen

class MissionsScreen : SupportAppScreen() {

    override fun getScreenKey() = MissionsFragment.TAG

    override fun getFragment() = MissionsFragment.newInstance()
}
