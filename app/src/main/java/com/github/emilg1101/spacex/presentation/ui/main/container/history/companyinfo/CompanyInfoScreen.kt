package com.github.emilg1101.spacex.presentation.ui.main.container.history.companyinfo

import ru.terrakok.cicerone.android.support.SupportAppScreen

class CompanyInfoScreen : SupportAppScreen() {

    override fun getScreenKey() = CompanyInfoFragment.TAG

    override fun getFragment() = CompanyInfoFragment.newInstance()
}
