package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.DividerItemDecoration.HORIZONTAL
import android.support.v7.widget.DividerItemDecoration.VERTICAL
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.CapsulesAdapter
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import com.github.emilg1101.spacex.presentation.model.CapsuleItemModel
import kotlinx.android.synthetic.main.fragment_capsules.*
import kotlinx.android.synthetic.main.layout_toolbar.toolbar
import javax.inject.Inject
import javax.inject.Provider

class CapsulesFragment : BaseFragment(), CapsulesView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): CapsulesPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: CapsulesPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<CapsulesPresenter>

    @field:Inject
    lateinit var capsulesAdapter: CapsulesAdapter

    override val contentLayout: Int = R.layout.fragment_capsules

    override fun getToolbar(): Toolbar = toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        list.adapter = capsulesAdapter
        list.layoutManager = LinearLayoutManager(context)
        list.addItemDecoration(DividerItemDecoration(context, VERTICAL))
    }

    override fun showCapsules(items: List<CapsuleItemModel>) {
        capsulesAdapter.items = items
        capsulesAdapter.onItemClick = {
            presenter.openCapsule(it)
        }
    }

    override fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progress_bar.visibility = View.GONE
    }

    companion object {

        val TAG: String = CapsulesFragment::class.java.name

        fun newInstance() = CapsulesFragment()
    }
}
