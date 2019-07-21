package com.github.emilg1101.spacex.presentation.base

abstract class ContainerFragment : BaseFragment() {

    abstract val containerId: Int

    override fun onBackPressed(): Boolean {
        val stackSize = childFragmentManager.backStackEntryCount
        if (stackSize == 0) {
            return false
        }
        childFragmentManager.popBackStack()
        return true
    }
}
