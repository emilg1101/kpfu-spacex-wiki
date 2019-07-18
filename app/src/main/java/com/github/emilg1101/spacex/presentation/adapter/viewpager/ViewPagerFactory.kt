package com.github.emilg1101.spacex.presentation.adapter.viewpager

import android.support.v4.app.Fragment

interface ViewPagerFactory {

    fun getInstance(): Fragment
}