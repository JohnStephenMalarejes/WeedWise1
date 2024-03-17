package com.tepdev.weedwise

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.tepdev.weedwise.BroadleavesData.BroadLeavesFragment
import com.tepdev.weedwise.GrassData.GrassFragment
import com.tepdev.weedwise.SedgesData.SedgesFragment

class MyPageAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {

        when (position) {
            0 -> return GrassFragment()
            1 -> return SedgesFragment()
            2 -> return BroadLeavesFragment()

            else -> return GrassFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Grass"
            1 -> return "Sedges"
            2 -> return "Broadleaves"
            else -> return "Grass"
        }
    }
}