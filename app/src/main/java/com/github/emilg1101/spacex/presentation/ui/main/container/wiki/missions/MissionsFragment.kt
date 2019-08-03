package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.missions

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
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

    override val contentLayout = R.layout.fragment_missions

    override fun getToolbar(): Toolbar = toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    companion object {

        val TAG = MissionsFragment::class.java.name

        fun newInstance() = MissionsFragment()
    }
}
