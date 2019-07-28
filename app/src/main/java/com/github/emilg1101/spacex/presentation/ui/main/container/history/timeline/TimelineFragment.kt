package com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline

import android.support.v7.widget.Toolbar
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
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

    override val contentLayout = R.layout.fragment_timeline

    override fun getToolbar(): Toolbar = toolbar

    override fun enableBackPressed(): Boolean = false

    companion object {

        val TAG: String = TimelineFragment::class.java.name

        fun newInstance() = TimelineFragment()
    }
}
