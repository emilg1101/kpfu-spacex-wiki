package com.github.emilg1101.spacex.presentation.ui.main

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.ContainerActivity
import dagger.android.AndroidInjection
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : ContainerActivity(), MainView {

    @ProvidePresenter
    fun providePresenter(): MainPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<MainPresenter>

    @field:Inject
    @field:MainQualifier
    lateinit var navigatorHolder: NavigatorHolder

    @field:Inject
    @field:MainQualifier
    lateinit var navigator: Navigator

    override val containerId = R.id.container

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}
