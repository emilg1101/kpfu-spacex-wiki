package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores.core

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.ShortMissionsAdapter
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import com.github.emilg1101.spacex.presentation.model.MissionItemShortModel
import kotlinx.android.synthetic.main.fragment_core.*
import kotlinx.android.synthetic.main.layout_toolbar.toolbar
import javax.inject.Inject
import javax.inject.Provider

class CoreFragment : BaseFragment(), CoreView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): CorePresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: CorePresenter

    @field:Inject
    lateinit var presenterProvider: Provider<CorePresenter>

    @field:Inject
    lateinit var missionsAdapter: ShortMissionsAdapter

    override val contentLayout = R.layout.fragment_core

    override fun getToolbar(): Toolbar = toolbar

    fun getSerial(): String = arguments?.getString(SERIAL) ?: throw IllegalArgumentException()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_missions.adapter = missionsAdapter
        list_missions.layoutManager = LinearLayoutManager(context)
    }

    override fun showBlock(block: String) {
        text_block.text = "Block $block"
    }

    override fun showStatus(status: String) {
        text_status.text = status
    }

    override fun showLaunchTime(launchTime: String) {
        text_launch.text = launchTime
    }

    override fun showDetails(details: String) {
        text_details.text = details
    }

    override fun showReuseCount(reuseCount: Int) {
        text_reuse.text = reuseCount.toString()
    }

    override fun showRtlsAttempts(rtlsAttempts: Int) {
        text_rtls_attempts.text = rtlsAttempts.toString()
    }

    override fun showRtlsLandings(rtlsLandings: Int) {
        text_rtls_landings.text = rtlsLandings.toString()
    }

    override fun showAsdsAttempts(asdsAttempts: Int) {
        text_asds_attempts.text = asdsAttempts.toString()
    }

    override fun showAsdsLandings(asdsLandings: Int) {
        text_asds_landings.text = asdsLandings.toString()
    }

    override fun showWaterLanding(waterLanding: String) {
        text_water_landing.text = waterLanding
    }

    override fun showMissions(items: List<MissionItemShortModel>) {
        if (items.isEmpty()) {
            label_missions.visibility = View.GONE
            list_missions.visibility = View.GONE
        }
        missionsAdapter.items = items
        missionsAdapter.onItemClick = {
            presenter.openMission(it)
        }
    }

    override fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progress_bar.visibility = View.GONE
    }

    companion object {

        val TAG = CoreFragment::class.java.name
        private const val SERIAL = "serial"

        fun newInstance(serial: String) = CoreFragment().also {
            it.arguments = Bundle().apply {
                putString(SERIAL, serial)
            }
        }
    }
}
