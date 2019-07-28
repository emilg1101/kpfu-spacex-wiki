package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.content

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import javax.inject.Inject
import javax.inject.Provider

class ContentFragment : BaseFragment(), ContentView {

    @ProvidePresenter
    fun providePresenter(): ContentPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: ContentPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<ContentPresenter>

    override val contentLayout = R.layout.fragment_content

    companion object {

        val TAG: String = ContentFragment::class.java.name

        fun newInstance() = ContentFragment()
    }
}
