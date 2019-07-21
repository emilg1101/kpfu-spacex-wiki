package com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import javax.inject.Inject
import javax.inject.Provider

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

        const val FLIGHT_NUMBER = "flight_number"

        fun newInstance(flightNumber: Int) = LaunchFragment().also {
            it.arguments = Bundle().apply {
                putInt(FLIGHT_NUMBER, flightNumber)
            }
        }
    }
}
