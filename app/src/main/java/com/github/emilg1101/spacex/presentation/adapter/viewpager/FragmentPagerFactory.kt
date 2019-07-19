package com.github.emilg1101.spacex.presentation.adapter.viewpager

import android.support.v4.app.Fragment

interface FragmentPagerFactory {

    fun getInstance(): Fragment

    fun getTitle(): String = ""

    fun getId(position: Int): Long = position.toLong()
}