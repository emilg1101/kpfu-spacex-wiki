package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.content

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import kotlinx.android.synthetic.main.fragment_content.*
import javax.inject.Inject
import javax.inject.Provider

class ContentFragment : BaseFragment(), ContentView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): ContentPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: ContentPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<ContentPresenter>

    override val contentLayout = R.layout.fragment_content

    override fun getToolbar(): Toolbar = toolbar

    override fun enableBackPressed(): Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        setListeners()
    }

    private fun setListeners() {
        label_capsules.setOnClickListener { presenter.openCapsules() }
        label_missions.setOnClickListener { presenter.openMissions() }
        label_payloads.setOnClickListener { presenter.openPayloads() }
        label_cores.setOnClickListener { presenter.openCores() }
        label_rockets.setOnClickListener { presenter.openRockets() }
    }

    companion object {

        val TAG: String = ContentFragment::class.java.name

        fun newInstance() = ContentFragment()
    }
}
