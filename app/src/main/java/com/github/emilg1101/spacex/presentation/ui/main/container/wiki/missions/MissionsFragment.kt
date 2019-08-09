package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.MissionsAdapter
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import com.github.emilg1101.spacex.presentation.model.MissionItemModel
import kotlinx.android.synthetic.main.fragment_capsules.*
import kotlinx.android.synthetic.main.fragment_missions.*
import kotlinx.android.synthetic.main.fragment_missions.list
import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject
import javax.inject.Provider

class MissionsFragment : BaseFragment(), MissionsView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): MissionsPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: MissionsPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<MissionsPresenter>

    @field:Inject
    lateinit var missionsAdapter: MissionsAdapter

    override val contentLayout = R.layout.fragment_missions

    override fun getToolbar(): Toolbar = toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        list.adapter = missionsAdapter
        list.layoutManager = LinearLayoutManager(context)
        list.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    override fun showMissions(items: List<MissionItemModel>) {
        missionsAdapter.items = items
        missionsAdapter.onItemClick = {
            presenter.openMission(it)
        }
    }

    companion object {

        val TAG = MissionsFragment::class.java.name

        fun newInstance() = MissionsFragment()
    }
}
