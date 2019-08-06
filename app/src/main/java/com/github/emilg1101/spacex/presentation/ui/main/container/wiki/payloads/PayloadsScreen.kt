package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads

import ru.terrakok.cicerone.android.support.SupportAppScreen

class PayloadsScreen : SupportAppScreen() {

    override fun getScreenKey() = PayloadsFragment.TAG

    override fun getFragment() = PayloadsFragment.newInstance()
}
