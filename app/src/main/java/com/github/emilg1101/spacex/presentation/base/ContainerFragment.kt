package com.github.emilg1101.spacex.presentation.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View

abstract class ContainerFragment : BaseFragment() {

    abstract val containerId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentManager.registerFragmentLifecycleCallbacks(object :
                FragmentManager.FragmentLifecycleCallbacks() {

            override fun onFragmentViewCreated(
                    fm: FragmentManager,
                    f: Fragment,
                    v: View,
                    savedInstanceState: Bundle?
            ) {
                super.onFragmentViewCreated(fm, f, v, savedInstanceState)
                /*if (f is MoxyFragment) {
                    val stackSize = supportFragmentManager.backStackEntryCount
                    val toolbar = f.getToolbar()
                    setSupportActionBar(toolbar)
                    onFragmentScreenChanged(stackSize)
                    while (actionBarRunnableQueue.isNotEmpty()) {
                        actionBarRunnableQueue.poll().run()
                    }
                }*/
                if (f is HasToolbar) {
                    baseActivity?.setSupportActionBar(f.getToolbar())
                    baseActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
                }
            }

            override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                super.onFragmentViewDestroyed(fm, f)
                if (f is HasToolbar) {
                    baseActivity?.setSupportActionBar(null)
                }
            }

        }, false)
    }

    override fun onBackPressed(): Boolean {
        val stackSize = childFragmentManager.backStackEntryCount
        if (stackSize == 0) {
            return false
        }
        childFragmentManager.popBackStack()
        return true
    }
}
