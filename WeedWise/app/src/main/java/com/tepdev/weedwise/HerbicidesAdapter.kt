package com.tepdev.weedwise

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class HerbicidesAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {

        when (position) {
            0 -> return TransplantedFragment()
            1 -> return DirectSeededFragment()

            else -> return TransplantedFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "TRANSPLANTED"
            1 -> return "DIRECT-SEEDED"

            else -> return "TRANSPLANTED"
        }
    }
}