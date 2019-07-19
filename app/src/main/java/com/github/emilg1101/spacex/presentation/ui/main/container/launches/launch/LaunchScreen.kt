package com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch

import ru.terrakok.cicerone.android.support.SupportAppScreen

class LaunchScreen : SupportAppScreen() {

    override fun getScreenKey() = LaunchFragment.TAG

    override fun getFragment() = LaunchFragment.newInstance()
}
