package com.github.emilg1101.spacex.presentation.ui.main.container

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.viewpager.CustomizeFragmentPagerAdapter
import com.github.emilg1101.spacex.presentation.adapter.viewpager.FragmentPagerFactory
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.history.HistoryFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.launches.LaunchesFragment
import com.github.emilg1101.spacex.presentation.ui.main.container.wiki.WikiFragment
import kotlinx.android.synthetic.main.fragment_bottom_main_container.*
import javax.inject.Inject
import javax.inject.Provider

class BottomMainContainerFragment : BaseFragment(), BottomMainContainerView {

    @ProvidePresenter
    fun providePresenter(): BottomMainContainerPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: BottomMainContainerPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<BottomMainContainerPresenter>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBottomNavBar()

        viewpager.adapter = CustomizeFragmentPagerAdapter(childFragmentManager).apply {
            this.factoryFragmentPageList = arrayListOf(
                    object : FragmentPagerFactory {
                        override fun getInstance(): Fragment {
                            return LaunchesFragment.newInstance()
                        }
                    },
                    object : FragmentPagerFactory {
                        override fun getInstance(): Fragment {
                            return WikiFragment.newInstance()
                        }
                    },
                    object : FragmentPagerFactory {
                        override fun getInstance(): Fragment {
                            return HistoryFragment.newInstance()
                        }
                    }
            )
        }
    }

    override fun swipePage(position: Int) {
        viewpager.setCurrentItem(position, false)
    }

    private fun initBottomNavBar() {
        bottom_bar.setOnNavigationItemSelectedListener {
            presenter.onNavigationItemClick(
                    when (it.itemId) {
                        R.id.action_item_launches -> 0
                        R.id.action_item_wiki -> 1
                        else -> 2
                    }
            )
            true
        }
    }

    override val contentLayout = R.layout.fragment_bottom_main_container

    companion object {

        val TAG: String = BottomMainContainerFragment::class.java.name

        fun newInstance() = BottomMainContainerFragment()
    }
}
