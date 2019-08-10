package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules.capsule

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
import kotlinx.android.synthetic.main.fragment_capsule.*
import kotlinx.android.synthetic.main.layout_toolbar.toolbar
import javax.inject.Inject
import javax.inject.Provider

class CapsuleFragment : BaseFragment(), CapsuleView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): CapsulePresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: CapsulePresenter

    @field:Inject
    lateinit var presenterProvider: Provider<CapsulePresenter>

    @field:Inject
    lateinit var missionsAdapter: ShortMissionsAdapter

    override val contentLayout: Int = R.layout.fragment_capsule

    override fun getToolbar(): Toolbar = toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        list_missions.adapter = missionsAdapter
        list_missions.layoutManager = LinearLayoutManager(context)
    }

    fun getCapsuleSerial() = arguments?.getString(CAPSULE_SERIAL)
        ?: throw IllegalArgumentException()

    override fun showDetails(details: String) {
        text_details.text = details
    }

    override fun showStatus(status: String) {
        text_status.text = status
    }

    override fun showLaunchTime(launchTime: String) {
        text_launch.text = launchTime
    }

    override fun showLandings(landings: String) {
        text_landings.text = landings
    }

    override fun showType(type: String) {
        text_type.text = type
    }

    override fun showReuseCount(reuseCount: String) {
        text_reuse.text = reuseCount
    }

    override fun showMissions(items: List<MissionItemShortModel>) {
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

        val TAG: String = CapsuleFragment::class.java.name

        private const val CAPSULE_SERIAL = "capsule_serial"

        fun newInstance(capsuleSerial: String) = CapsuleFragment().also {
            it.arguments = Bundle().apply {
                putString(CAPSULE_SERIAL, capsuleSerial)
            }
        }
    }
}
