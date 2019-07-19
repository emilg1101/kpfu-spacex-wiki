package com.github.emilg1101.spacex.presentation.ui.main.container.history.timeline

import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider
import com.github.emilg1101.spacex.R

class TimelineFragment : BaseFragment(), TimelineView {

    @ProvidePresenter
    fun providePresenter(): TimelinePresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: TimelinePresenter

    @field:Inject
    lateinit var presenterProvider: Provider<TimelinePresenter>

    override val contentLayout = R.layout.fragment_timeline

    companion object {

        val TAG: String = TimelineFragment::class.java.name

        fun newInstance() = TimelineFragment()
    }
}
