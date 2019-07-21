package com.github.emilg1101.spacex.presentation.ui.main.container.launches.upcoming

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.UpcomingLaunchesAdapter
import com.github.emilg1101.spacex.presentation.model.UpcomingLaunchItemModel
import kotlinx.android.synthetic.main.fragment_upcoming_launches.*
import javax.inject.Inject
import javax.inject.Provider

class UpcomingLaunchesFragment : BaseFragment(), UpcomingLaunchesView {

    @ProvidePresenter
    fun providePresenter(): UpcomingLaunchesPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: UpcomingLaunchesPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<UpcomingLaunchesPresenter>

    @Inject
    lateinit var adapter: UpcomingLaunchesAdapter

    override val contentLayout = R.layout.fragment_upcoming_launches

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(context)
    }

    override fun setLaunches(items: List<UpcomingLaunchItemModel>) {
        adapter.items = items
        adapter.onItemClick = {
            presenter.openLaunch(it.flightNumber)
        }
    }

    companion object {

        val TAG: String = UpcomingLaunchesFragment::class.java.name

        fun newInstance() = UpcomingLaunchesFragment()
    }
}
