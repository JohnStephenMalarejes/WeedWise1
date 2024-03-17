package com.tepdev.weedwise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the TextView by its ID within the fragment's view
        val about = view.findViewById<TextView>(R.id.about)
        val about2 = view.findViewById<TextView>(R.id.about2)

        // The provided text
        val aboutText = "Weeds are among the major groups of pests that farmers always consider as limiting factors in rice production. If not controlled, weeds can be reduce yield of rice from 44 to 96% by way of competetion for the limited resources for growth and development such as nutrients, sunlight and water."
        val about2Text = "Weeds can also cause increase in cost of rice production. They can also reduce the quality and value of rice grains through the contamination of their seeds during harvest. They, too, can serve as alternate hosts and refuges of disease-causing pathogens, insect pests, rats, and other pests of rice."

        // Set the provided text to the TextView
        about.text = aboutText
        about2.text = about2Text


    }
}