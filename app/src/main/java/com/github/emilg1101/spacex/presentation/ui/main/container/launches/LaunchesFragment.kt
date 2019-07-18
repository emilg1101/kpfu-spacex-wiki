package com.github.emilg1101.spacex.presentation.ui.main.container.launches

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.ContainerFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import javax.inject.Provider

class LaunchesFragment : ContainerFragment(), LaunchesView {

    @ProvidePresenter
    fun providePresenter(): LaunchesPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: LaunchesPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<LaunchesPresenter>

    @field:Inject
    @field:LaunchesQualifier
    lateinit var navigatorHolder: NavigatorHolder

    @field:Inject
    @field:LaunchesQualifier
    lateinit var navigator: Navigator

    override val contentLayout = R.layout.fragment_launches

    override val containerId = R.id.container

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    companion object {

        val TAG: String = LaunchesFragment::class.java.name

        fun newInstance() = LaunchesFragment()
    }
}
