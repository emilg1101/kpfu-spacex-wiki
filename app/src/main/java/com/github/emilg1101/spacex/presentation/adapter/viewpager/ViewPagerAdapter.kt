package com.github.emilg1101.spacex.presentation.adapter.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.github.emilg1101.spacex.presentation.adapter.viewpager.ViewPagerFactory

class ViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    var list: List<ViewPagerFactory> = emptyList()
    set(value)  {
        field = value
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        return list[position].getInstance()
    }

    override fun getCount(): Int {
        return list.size
    }
}