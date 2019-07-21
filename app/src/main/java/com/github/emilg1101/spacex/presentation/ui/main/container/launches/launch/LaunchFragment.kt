package com.github.emilg1101.spacex.presentation.ui.main.container.launches.launch

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject
import javax.inject.Provider

class LaunchFragment : BaseFragment(), LaunchView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): LaunchPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: LaunchPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<LaunchPresenter>

    override val contentLayout = R.layout.fragment_launch

    override fun getToolbar(): Toolbar = toolbar

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
