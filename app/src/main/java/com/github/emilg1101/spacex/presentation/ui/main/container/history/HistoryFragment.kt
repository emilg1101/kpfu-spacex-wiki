package com.github.emilg1101.spacex.presentation.ui.main.container.history

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.ContainerFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import javax.inject.Provider

class HistoryFragment : ContainerFragment(), HistoryView {

    @ProvidePresenter
    fun providePresenter(): HistoryPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: HistoryPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<HistoryPresenter>

    @field:Inject
    @field:HistoryQualifier
    lateinit var navigatorHolder: NavigatorHolder

    @field:Inject
    @field:HistoryQualifier
    lateinit var navigator: Navigator

    override val contentLayout = R.layout.fragment_history

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

        val TAG: String = HistoryFragment::class.java.name

        fun newInstance() = HistoryFragment()
    }
}
