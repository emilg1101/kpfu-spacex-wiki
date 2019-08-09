package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.capsule

import ru.terrakok.cicerone.android.support.SupportAppScreen

class CapsuleScreen(private val capsuleSerial: String) : SupportAppScreen() {

    override fun getScreenKey() = CapsuleFragment.TAG

    override fun getFragment() = CapsuleFragment.newInstance(capsuleSerial)
}
