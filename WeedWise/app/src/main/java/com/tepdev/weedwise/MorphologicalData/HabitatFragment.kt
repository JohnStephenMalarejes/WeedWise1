package com.tepdev.weedwise.MorphologicalData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tepdev.weedwise.R


class HabitatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_habitat, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the TextView by its ID within the fragment's view
        val aquatic = view.findViewById<TextView>(R.id.aquatic)
        val semiAquatic = view.findViewById<TextView>(R.id.semi_aquatic)
        val terestrial = view.findViewById<TextView>(R.id.terrestrial)

        // The provided text
        val aquaticText = "Weeds that emerge and grow in very wet or submerged soils (wet to moist)"
        val semiAquaticText = "Weeds that row in dry lands with some tolerance to submergence conditions (dry to weet)"
        val terrestrialText = "Weeds that grow in dry lands (moist to dry)"

        // Set the provided text to the TextView
        aquatic.text = aquaticText
        semiAquatic.text = semiAquaticText
       terestrial.text = terrestrialText

    }

}