package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.payloads

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.PayloadsAdapter
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import com.github.emilg1101.spacex.presentation.model.PayloadItemModel
import kotlinx.android.synthetic.main.fragment_payloads.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.toolbar

class PayloadsFragment : BaseFragment(), PayloadsView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): PayloadsPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: PayloadsPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<PayloadsPresenter>

    @field:Inject
    lateinit var payloadsAdapter: PayloadsAdapter

    override val contentLayout = R.layout.fragment_payloads

    override fun getToolbar(): Toolbar = toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.adapter = payloadsAdapter
        list.layoutManager = LinearLayoutManager(context)
    }

    override fun showPayloads(items: List<PayloadItemModel>) {
        payloadsAdapter.items = items
        payloadsAdapter.onItemClick = {
            presenter.openPayload(it)
        }
    }

    companion object {

        val TAG = PayloadsFragment::class.java.name

        fun newInstance() = PayloadsFragment()
    }
}
