package com.github.emilg1101.spacex.presentation.ui.main.container.launches.container

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.viewpager.CustomizeFragmentPagerAdapter
import com.github.emilg1101.spacex.presentation.adapter.viewpager.FragmentPagerFactory
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.past.PastLaunchesFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.upcoming.UpcomingLaunchesFragment
import kotlinx.android.synthetic.main.fragment_launches_container.*
import javax.inject.Inject
import javax.inject.Provider

class LaunchesContainerFragment : BaseFragment(), LaunchesContainerView {

    @ProvidePresenter
    fun providePresenter(): LaunchesContainerPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: LaunchesContainerPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<LaunchesContainerPresenter>

    override val contentLayout = R.layout.fragment_launches_container

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewpager.adapter = CustomizeFragmentPagerAdapter(childFragmentManager).apply {
            this.factoryFragmentPageList = arrayListOf(
                    object : FragmentPagerFactory {
                        override fun getInstance(): Fragment {
                            return UpcomingLaunchesFragment.newInstance()
                        }

                        override fun getTitle(): String {
                            return "Upcoming"
                        }
                    },
                    object : FragmentPagerFactory {
                        override fun getInstance(): Fragment {
                            return PastLaunchesFragment.newInstance()
                        }

                        override fun getTitle(): String {
                            return "Past"
                        }
                    }
            )
        }
        tab_layout.setupWithViewPager(viewpager)
    }

    companion object {

        val TAG: String = LaunchesContainerFragment::class.java.name

        fun newInstance() = LaunchesContainerFragment()
    }
}
