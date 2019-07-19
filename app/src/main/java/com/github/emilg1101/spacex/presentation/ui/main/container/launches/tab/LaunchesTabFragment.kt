package com.github.emilg1101.spacex.presentation.ui.main.container.launches.tab

import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider
import com.github.emilg1101.spacex.R

class LaunchesTabFragment : BaseFragment(), LaunchesTabView {

    @ProvidePresenter
    fun providePresenter(): LaunchesTabPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: LaunchesTabPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<LaunchesTabPresenter>

    override val contentLayout = R.layout.fragment_launches_tab

    companion object {

        val TAG: String = LaunchesTabFragment::class.java.name

        fun newInstance() = LaunchesTabFragment()
    }
}
