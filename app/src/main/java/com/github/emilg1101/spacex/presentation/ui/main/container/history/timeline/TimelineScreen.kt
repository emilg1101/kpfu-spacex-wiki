package com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline

import ru.terrakok.cicerone.android.support.SupportAppScreen

class TimelineScreen : SupportAppScreen() {

    override fun getScreenKey() = TimelineFragment.TAG

    override fun getFragment() = TimelineFragment.newInstance()
}
