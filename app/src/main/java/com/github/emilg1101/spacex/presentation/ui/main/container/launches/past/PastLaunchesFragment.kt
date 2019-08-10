package com.github.emilg1101.spacex.presentation.ui.main.container.launches.past

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.PastLaunchesAdapter
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.model.PastLaunchItemModel
import kotlinx.android.synthetic.main.fragment_past_launches.*
import javax.inject.Inject
import javax.inject.Provider

class PastLaunchesFragment : BaseFragment(), PastLaunchesView {

    @ProvidePresenter
    fun providePresenter(): PastLaunchesPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: PastLaunchesPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<PastLaunchesPresenter>

    @Inject
    lateinit var adapter: PastLaunchesAdapter

    override val contentLayout = R.layout.fragment_past_launches

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(context)
    }

    override fun setLaunches(items: List<PastLaunchItemModel>) {
        adapter.items = items
        adapter.onItemClick = {
            presenter.openLaunch(it)
        }
    }

    override fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progress_bar.visibility = View.GONE
    }

    companion object {

        val TAG: String = PastLaunchesFragment::class.java.name

        fun newInstance() = PastLaunchesFragment()
    }
}
