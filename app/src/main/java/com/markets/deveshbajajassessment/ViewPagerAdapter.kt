package com.markets.deveshbajajassessment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter// this is a secondary constructor of ViewPagerAdapter class.
    (supportFragmentManager: FragmentManager) : FragmentPagerAdapter(supportFragmentManager) {

    private var fragmentList1: ArrayList<Fragment> = ArrayList()
    private var fragmentTitleList1: ArrayList<String> = ArrayList()

    override fun getCount(): Int {
        return fragmentList1.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList1[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList1.add(fragment)
        fragmentTitleList1.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList1[position]
    }
}