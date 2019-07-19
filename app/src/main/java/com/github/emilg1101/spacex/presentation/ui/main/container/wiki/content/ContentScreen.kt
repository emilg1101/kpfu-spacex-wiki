package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.content

import ru.terrakok.cicerone.android.support.SupportAppScreen

class ContentScreen : SupportAppScreen() {

    override fun getScreenKey() = ContentFragment.TAG

    override fun getFragment() = ContentFragment.newInstance()
}
