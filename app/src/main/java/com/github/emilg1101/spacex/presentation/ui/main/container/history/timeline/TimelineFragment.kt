package com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.*
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.HistoryAdapter
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import com.github.emilg1101.spacex.presentation.model.HistoricalEventItemModel
import kotlinx.android.synthetic.main.fragment_timeline.*
import javax.inject.Inject
import javax.inject.Provider

class TimelineFragment : BaseFragment(), TimelineView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): TimelinePresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: TimelinePresenter

    @field:Inject
    lateinit var presenterProvider: Provider<TimelinePresenter>

    @field:Inject
    lateinit var historyAdapter: HistoryAdapter

    override val contentLayout = R.layout.fragment_timeline

    override fun getToolbar(): Toolbar = toolbar

    override fun enableBackPressed(): Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list_events.adapter = historyAdapter
        list_events.layoutManager = LinearLayoutManager(context)
    }

    override fun showEvents(items: List<HistoricalEventItemModel>) {
        historyAdapter.items = items
        historyAdapter.onItemClick = {
            presenter.openLaunch(it)
        }
        historyAdapter.onLinkClick = {
            presenter.openLink(it)
        }
    }

    override fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progress_bar.visibility = View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        if (menu?.size() == 0) {
            inflater?.inflate(R.menu.menu_timeline, menu)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_about) {
            presenter.openAboutCompany()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {

        val TAG: String = TimelineFragment::class.java.name

        fun newInstance() = TimelineFragment()
    }
}
