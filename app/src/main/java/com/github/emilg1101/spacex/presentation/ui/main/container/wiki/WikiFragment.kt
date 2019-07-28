package com.github.emilg1101.spacex.presentation.ui.main.container.wiki

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.ContainerFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import javax.inject.Provider

class WikiFragment : ContainerFragment(), WikiView {

    @ProvidePresenter
    fun providePresenter(): WikiPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: WikiPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<WikiPresenter>

    @field:Inject
    @field:WikiQualifier
    lateinit var navigatorHolder: NavigatorHolder

    @field:Inject
    @field:WikiQualifier
    lateinit var navigator: Navigator

    override val contentLayout = R.layout.fragment_wiki

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

        val TAG: String = WikiFragment::class.java.name

        fun newInstance() = WikiFragment()
    }
}
