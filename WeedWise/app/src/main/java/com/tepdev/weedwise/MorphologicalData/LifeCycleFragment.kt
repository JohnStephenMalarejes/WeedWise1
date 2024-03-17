package com.tepdev.weedwise.MorphologicalData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tepdev.weedwise.R

class LifeCycleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_life_cycle, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the TextView by its ID within the fragment's view
        val annual = view.findViewById<TextView>(R.id.annual)
        val perrenial = view.findViewById<TextView>(R.id.perennial)

        // The provided text
        val annualText = "Weeds that complete their life cycle from seed to seed in less than one year or in one growing season."
        val perrenialText = "Weeds that complete their life cycle in more than a year. They can they can be simple or creeping. Simple perennials spread through seeds and by vegetative propagations.They may regenerate vegetatively into a new plant if their shoots are injured or cut off from the mother plant. Creeping perennialon the other hand, are those that reproduce by seeds and vegatative organs such as stolons(creeping above-ground stems), rhizomes(creeping below-ground stems), tubers, aerial bulblets, and bulbs"

        // Set the provided text to the TextView
        annual.text = annualText
        perrenial.text = perrenialText

    }

}