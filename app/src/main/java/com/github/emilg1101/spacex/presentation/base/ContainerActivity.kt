package com.github.emilg1101.spacex.presentation.base

import android.view.Menu
import android.view.MenuItem

abstract class ContainerActivity : BaseActivity() {

    abstract val containerId: Int

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                false
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

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
