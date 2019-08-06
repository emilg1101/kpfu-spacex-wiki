package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads.payload

import ru.terrakok.cicerone.android.support.SupportAppScreen

class PayloadScreen(private val payloadId: String) : SupportAppScreen() {

    override fun getScreenKey() = PayloadFragment.TAG

    override fun getFragment() = PayloadFragment.newInstance(payloadId)
}
