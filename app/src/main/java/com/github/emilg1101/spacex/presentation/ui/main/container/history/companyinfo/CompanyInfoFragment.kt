package com.github.emilg1101.spacex.presentation.ui.main.container.history.companyinfo

import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider
import com.github.emilg1101.spacex.R

class CompanyInfoFragment : BaseFragment(), CompanyInfoView {

    @ProvidePresenter
    fun providePresenter(): CompanyInfoPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: CompanyInfoPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<CompanyInfoPresenter>

    override val contentLayout = R.layout.fragment_company_info

    companion object {

        val TAG: String = CompanyInfoFragment::class.java.name

        fun newInstance() = CompanyInfoFragment()
    }
}
