package com.github.emilg1101.spacex.presentation.adapter.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.github.emilg1101.spacex.presentation.adapter.viewpager.FragmentPagerFactory

class CustomizeFragmentPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {

    var factoryFragmentPageList: List<FragmentPagerFactory> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItem(position: Int): Fragment {
        return factoryFragmentPageList[position].getInstance()
    }

    override fun getCount(): Int {
        return factoryFragmentPageList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return factoryFragmentPageList[position].getTitle()
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }
}