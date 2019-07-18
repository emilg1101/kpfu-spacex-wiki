package com.github.emilg1101.spacex.presentation.ui.main.container

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.View
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.adapter.viewpager.ViewPagerAdapter
import com.github.emilg1101.spacex.presentation.adapter.viewpager.ViewPagerFactory
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

        viewpager.adapter = ViewPagerAdapter(childFragmentManager).apply {
            this.list = arrayListOf(object : ViewPagerFactory {
                override fun getInstance(): Fragment {
                    return LaunchesFragment.newInstance()
                }
            }, object : ViewPagerFactory {
                override fun getInstance(): Fragment {
                    return WikiFragment.newInstance()
                }
            }, object : ViewPagerFactory {
                override fun getInstance(): Fragment {
                    return HistoryFragment.newInstance()
                }
            })
        }
    }

    override fun swipePage(position: Int) {
        viewpager.setCurrentItem(position, false)
    }

    private fun initBottomNavBar() {
        bottom_bar.defaultBackgroundColor = ContextCompat.getColor(requireContext(), R.color.item_background)
        bottom_bar.accentColor = Color.parseColor("#ffffff")
        bottom_bar.inactiveColor = Color.parseColor("#d2e6f0")
        bottom_bar.setNotificationBackgroundColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
        bottom_bar.titleState = AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE_FORCE

        val navigationAdapter = AHBottomNavigationAdapter(activity, R.menu.bottombar_menu)
        navigationAdapter.setupWithBottomNavigation(bottom_bar)

        bottom_bar.isBehaviorTranslationEnabled = false

        bottom_bar.setOnTabSelectedListener { position, _ ->
            presenter.onNavigationItemClick(position)
            true
        }
    }

    override val contentLayout = R.layout.fragment_bottom_main_container

    companion object {

        val TAG: String = BottomMainContainerFragment::class.java.name

        fun newInstance() = BottomMainContainerFragment()
    }
}
