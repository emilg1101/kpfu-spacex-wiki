package com.github.emilg1101.spacex.presentation.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseFragment : MvpAppCompatFragment(), HasSupportFragmentInjector, BaseView {

	@field:Inject
	lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

	override fun supportFragmentInjector(): AndroidInjector<Fragment> {
		return dispatchingAndroidInjector
	}

    abstract val contentLayout: Int

	val baseActivity get() = activity as? AppCompatActivity

	override fun onAttach(context: Context) {
		AndroidSupportInjection.inject(this)
		super.onAttach(context)
	}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(contentLayout, container, false)

    open fun onBackPressed() {}
}
