package com.github.emilg1101.spacex.presentation.ui.main.container.history.companyinfo

import android.support.v7.widget.Toolbar
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import kotlinx.android.synthetic.main.fragment_company_info.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject
import javax.inject.Provider

class CompanyInfoFragment : BaseFragment(), CompanyInfoView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): CompanyInfoPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: CompanyInfoPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<CompanyInfoPresenter>

    override val contentLayout = R.layout.fragment_company_info

    override fun getToolbar(): Toolbar? = toolbar

    override fun enableBackPressed(): Boolean = true

    override fun showSummary(summary: String) {
        text_summary.text = summary
    }

    override fun showFounder(founder: String) {
        text_founder.text = founder
    }

    override fun showCEO(ceo: String) {
        text_ceo.text = ceo
    }

    override fun showCOO(coo: String) {
        text_coo.text = coo
    }

    override fun showCTO(cto: String) {
        text_cto.text = cto
    }

    override fun showCTOPropulsion(ctoPropulsion: String) {
        text_cto_propulsion.text = ctoPropulsion
    }

    override fun showState(state: String) {
        text_state.text = state
    }

    override fun showCity(city: String) {
        text_city.text = city
    }

    override fun showAddress(address: String) {
        text_address.text = address
    }

    override fun showEmployees(employees: String) {
        text_employees.text = employees
    }

    override fun showVehicles(vehicles: String) {
        text_vehicles.text = vehicles
    }

    override fun showLaunchSites(launchSites: String) {
        text_launch_sites.text = launchSites
    }

    override fun showValuation(valuation: String) {
        text_valuation.text = valuation
    }

    companion object {

        val TAG: String = CompanyInfoFragment::class.java.name

        fun newInstance() = CompanyInfoFragment()
    }
}
