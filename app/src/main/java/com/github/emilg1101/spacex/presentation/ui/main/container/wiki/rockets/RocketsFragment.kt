package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.rockets

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.RocketsAdapter
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import com.github.emilg1101.spacex.presentation.model.RocketItemModel
import kotlinx.android.synthetic.main.fragment_rockets.*
import kotlinx.android.synthetic.main.layout_toolbar.toolbar
import javax.inject.Inject
import javax.inject.Provider

class RocketsFragment : BaseFragment(), RocketsView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): RocketsPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: RocketsPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<RocketsPresenter>

    @field:Inject
    lateinit var rocketsAdapter: RocketsAdapter

    override val contentLayout = R.layout.fragment_rockets

    override fun getToolbar(): Toolbar? = toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.adapter = rocketsAdapter
        list.layoutManager = LinearLayoutManager(context)
    }

    override fun showRockets(items: List<RocketItemModel>) {
        rocketsAdapter.items = items
        rocketsAdapter.onItemClick = {
            presenter.openRocket(it)
        }
    }

    companion object {

        val TAG = RocketsFragment::class.java.name

        fun newInstance() = RocketsFragment()
    }
}
