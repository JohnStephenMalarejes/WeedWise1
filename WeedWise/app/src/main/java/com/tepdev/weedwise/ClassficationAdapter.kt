package com.tepdev.weedwise

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.tepdev.weedwise.BroadleavesData.BroadLeavesFragment
import com.tepdev.weedwise.GrassData.GrassFragment
import com.tepdev.weedwise.MorphologicalData.HabitatFragment
import com.tepdev.weedwise.MorphologicalData.LifeCycleFragment
import com.tepdev.weedwise.MorphologicalData.MorphologicalFragment
import com.tepdev.weedwise.MorphologicalData.PhotosyntheticFragment
import com.tepdev.weedwise.SedgesData.SedgesFragment

class ClassficationAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {

        when (position) {
            0 -> return MorphologicalFragment()
            1 -> return LifeCycleFragment()
            2 -> return HabitatFragment()
            3 -> return PhotosyntheticFragment()

            else -> return MorphologicalFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Morphology"
            1 -> return "Life Cycle"
            2 -> return "Habitat"
            3 -> return "Photosynthetic Activity"
            else -> return "Morphology"
        }
    }
}