package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.cores

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.CoresAdapter
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import com.github.emilg1101.spacex.presentation.model.CoreItemModel
import kotlinx.android.synthetic.main.fragment_cores.*
import kotlinx.android.synthetic.main.layout_toolbar.toolbar
import javax.inject.Inject
import javax.inject.Provider

class CoresFragment : BaseFragment(), CoresView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): CoresPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: CoresPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<CoresPresenter>

    @field:Inject
    lateinit var coresAdapter: CoresAdapter

    override val contentLayout = R.layout.fragment_cores

    override fun getToolbar(): Toolbar = toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.adapter = coresAdapter
        list.layoutManager = LinearLayoutManager(context)
        list.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    override fun showCores(items: List<CoreItemModel>) {
        coresAdapter.items = items
        coresAdapter.onItemClick = {
            presenter.openCore(it)
        }
    }

    override fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progress_bar.visibility = View.GONE
    }

    companion object {

        val TAG = CoresFragment::class.java.name

        fun newInstance() = CoresFragment()
    }
}
