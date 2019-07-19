package com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch

import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider
import com.github.emilg1101.spacex.R

class LaunchFragment : BaseFragment(), LaunchView {

    @ProvidePresenter
    fun providePresenter(): LaunchPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: LaunchPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<LaunchPresenter>

    override val contentLayout = R.layout.fragment_launch

    companion object {

        val TAG: String = LaunchFragment::class.java.name

        fun newInstance() = LaunchFragment()
    }
}
