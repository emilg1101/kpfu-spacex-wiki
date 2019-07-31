package com.github.emilg1101.spacex.presentation.ui.main.container.wiki.capsules

import android.support.v7.widget.Toolbar
import com.github.emilg1101.spacex.presentation.base.BaseFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider
import com.github.emilg1101.spacex.R
import com.github.emilg1101.spacex.presentation.base.HasToolbar
import kotlinx.android.synthetic.main.layout_toolbar.*

class CapsulesFragment : BaseFragment(), CapsulesView, HasToolbar {

    @ProvidePresenter
    fun providePresenter(): CapsulesPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: CapsulesPresenter

    @field:Inject
    lateinit var presenterProvider: Provider<CapsulesPresenter>

    override val contentLayout: Int = R.layout.fragment_capsules

    override fun getToolbar(): Toolbar = toolbar

    companion object {

        val TAG: String = CapsulesFragment::class.java.name

        fun newInstance() = CapsulesFragment()
    }
}
