package com.github.emilg1101.spacex.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import ru.terrakok.cicerone.android.support.SupportAppScreen

class ExternalLinkScreen(private val url: String) : SupportAppScreen() {

    override fun getScreenKey() = "external_link"

    override fun getActivityIntent(context: Context?): Intent {
        return Intent(Intent.ACTION_VIEW, Uri.parse(url))
    }
}
