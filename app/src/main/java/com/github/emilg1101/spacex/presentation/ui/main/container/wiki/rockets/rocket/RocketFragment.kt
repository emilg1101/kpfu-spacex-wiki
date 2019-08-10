package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets.rocket

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import kotlinx.android.synthetic.main.fragment_rocket.*
import kotlinx.android.synthetic.main.layout_toolbar.toolbar
import javax.inject.Inject
import javax.inject.Provider

class RocketFragment : BaseFragment(), RocketView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): RocketPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: RocketPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<RocketPresenter>

    override val contentLayout = R.layout.fragment_rocket

    override fun getToolbar(): Toolbar = toolbar

    fun getRocketId(): String = arguments?.getString(ROCKET_ID) ?: throw IllegalArgumentException()

    override fun showFirstFlight(firstFlight: String) {
        text_launch.text = firstFlight
    }

    override fun showDescription(description: String) {
        text_details.text = description
    }

    override fun showCostPerLaunch(costPerLaunch: String) {
        text_cost_per_launch.text = "$costPerLaunch$"
    }

    override fun showCountry(country: String) {
        text_country.text = country
    }

    override fun showCompany(company: String) {
        text_company.text = company
    }

    override fun showEngine(engine: String) {
        text_engine.text = engine
    }

    override fun showStages(stages: String) {
        text_stages.text = stages
    }

    override fun showBoosters(boosters: String) {
        text_boosters.text = boosters
    }

    override fun showSuccessRate(successRate: String) {
        text_success_rate.text = "$successRate%"
    }

    override fun showHeight(height: String) {
        text_height.text = "$height m"
    }

    override fun showDiameter(diameter: String) {
        text_diameter.text = "$diameter m"
    }

    override fun showMass(mass: String) {
        text_mass.text = "$mass kg"
    }

    override fun setWikipediaLink(link: String) {
        button_wikipedia.setOnClickListener {
            presenter.openLink(link)
        }
    }

    override fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progress_bar.visibility = View.GONE
    }

    companion object {

        val TAG = RocketFragment::class.java.name
        private const val ROCKET_ID = "rocket_id"

        fun newInstance(rocketId: String) = RocketFragment().also {
            it.arguments = Bundle().apply {
                putString(ROCKET_ID, rocketId)
            }
        }
    }
}
