package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions.mission

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.MissionPayloadsAdapter
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import com.github.emilg1101.spacex.presentation.model.PayloadMissionItemModel
import com.github.emilg1101.spacex.presentation.util.ifNotBlankOrEmpty
import kotlinx.android.synthetic.main.fragment_mission.*
import kotlinx.android.synthetic.main.layout_toolbar.toolbar
import javax.inject.Inject
import javax.inject.Provider

class MissionFragment : BaseFragment(), MissionView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): MissionPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: MissionPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<MissionPresenter>

    @field:Inject
    lateinit var payloadsAdapter: MissionPayloadsAdapter

    override val contentLayout = R.layout.fragment_mission

    override fun getToolbar(): Toolbar = toolbar

    fun getMissionId(): String = arguments?.getString(MISSION_ID)
        ?: throw IllegalArgumentException()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_payloads.adapter = payloadsAdapter
        list_payloads.layoutManager = LinearLayoutManager(context)
    }

    override fun showDetails(details: String) {
        text_details.text = details
    }

    override fun showManufacturers(manufacturers: String) {
        text_manufacturers.text = manufacturers
    }

    override fun showPayloads(items: List<PayloadMissionItemModel>) {
        payloadsAdapter.items = items
        payloadsAdapter.onItemClick = {
            presenter.openPayload(it)
        }
    }

    override fun setWikipediaLink(link: String) {
        link.ifNotBlankOrEmpty { link ->
            chip_wikipedia.setOnClickListener {
                presenter.openLink(link)
            }
        }
    }

    override fun setWebsiteLink(link: String) {
        link.ifNotBlankOrEmpty { link ->
            chip_website.setOnClickListener {
                presenter.openLink(link)
            }
        }
    }

    override fun setTwitterLink(link: String) {
        link.ifNotBlankOrEmpty { link ->
            chip_twitter.setOnClickListener {
                presenter.openLink(link)
            }
        }
    }

    override fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progress_bar.visibility = View.GONE
    }

    companion object {

        val TAG = MissionFragment::class.java.name

        private const val MISSION_ID = "mission_id"

        fun newInstance(missionId: String) = MissionFragment().also {
            it.arguments = Bundle().apply {
                putString(MISSION_ID, missionId)
            }
        }
    }
}
