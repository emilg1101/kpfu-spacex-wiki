package com.github.emilg1101.spacex.presentation.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment : MvpAppCompatFragment(), HasAndroidInjector, BaseView {

    @field:Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    abstract val contentLayout: Int

    val baseActivity get() = activity as? AppCompatActivity

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(contentLayout, container, false)

    open fun onBackPressed(): Boolean {
        return false
    }

    override fun setToolbarTitle(text: String) {
        activity?.let {
            if (it is BaseView)
                it.setToolbarTitle(text)
        }
    }

    override fun setToolbarTitle(text: Int) {
        activity?.let {
            if (it is BaseView)
                it.setToolbarTitle(text)
        }
    }
}
