package com.tepdev.weedwise.MorphologicalData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tepdev.weedwise.R


class PhotosyntheticFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photosynthetic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the TextView by its ID within the fragment's view
        val targetTextView = view.findViewById<TextView>(R.id.c3weeds)
        val targetTextView2 = view.findViewById<TextView>(R.id.c4weeds)

        // The provided text
        val providedText = "Weeds that employ a photosynthetic pathway where a 3-carbon compound is the first stable product. Weeds belonging to this group prefer an environment where temperature and sunlight intensity are moderate, and water supply is plenty. C3 weeds, however, cannot tolerate very high temperature since they are prone to wasteful biochemical process called photorespiration. Thus, most of them are dominant in rice fields that are under submerged condition."
        val providedText2 = "Weeds that employ a more efficient photosynthetic pathway in which a 4-carbon compound is the first stable product. Weeds under this group have physiological adaptions that allow them to thrive in very hot and drier areas (dry land or rainfed conditions), and where concentrations of carbon dioxide are limited"

        // Set the provided text to the TextView
        targetTextView.text = providedText
        targetTextView2.text = providedText2

    }
}