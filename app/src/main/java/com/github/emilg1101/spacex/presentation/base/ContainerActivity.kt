package com.github.emilg1101.spacex.presentation.base

abstract class ContainerActivity : BaseActivity() {
    abstract val containerId: Int

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(containerId)
        if (fragment is BaseFragment) {
            if (!fragment.onBackPressed()) {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }
}
