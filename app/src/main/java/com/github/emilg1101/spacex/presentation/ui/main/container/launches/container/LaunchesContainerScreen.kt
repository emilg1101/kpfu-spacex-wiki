package com.github.emilg1101.spacex.presentation.ui.main.container.launches.container

import ru.terrakok.cicerone.android.support.SupportAppScreen

class LaunchesContainerScreen : SupportAppScreen() {

    override fun getScreenKey() = LaunchesContainerFragment.TAG

    override fun getFragment() = LaunchesContainerFragment.newInstance()
}
