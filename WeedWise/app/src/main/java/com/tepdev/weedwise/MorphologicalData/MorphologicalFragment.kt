package com.tepdev.weedwise.MorphologicalData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tepdev.weedwise.R

class MorphologicalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_morphological, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // grasses
        // Find the TextView by its ID within the fragment's view
        val grass1 = view.findViewById<TextView>(R.id.grass1)
        val grass2 = view.findViewById<TextView>(R.id.grass2)
        val grass3 = view.findViewById<TextView>(R.id.grass3)
        val grass4 = view.findViewById<TextView>(R.id.grass4)
        val grass5 = view.findViewById<TextView>(R.id.grass5)
        // The provided text
        val grassText1 = "• Members of the family Graminae (Poaceae)"
        val grassText2 = "• Leaves are long and narrow, which usually arise alternately in two rows from the nodes, and have ligules and sometimes auricles"
        val grassText3 = "• Leaf vein are in parralel while leaf sheaths are split around the stem"
        val grassText4 = "• Stems are called culns with well-defines nodes and internodes"
        val grassText5 = "• Stems are round and hollow inside"
        // Set the provided text to the TextView
        grass1.text = grassText1
        grass2.text = grassText2
        grass3.text = grassText3
        grass4.text = grassText4
        grass5.text = grassText5

        // grass
        // Find the TextView by its ID within the fragment's view
        val sedges1 = view.findViewById<TextView>(R.id.sedges1)
        val sedges2 = view.findViewById<TextView>(R.id.sedges2)
        val sedges3 = view.findViewById<TextView>(R.id.sedges3)
        val sedges4 = view.findViewById<TextView>(R.id.sedges4)

        // The provided text
        val sedgesText1 = "• Members of the family Cyperacea"
        val sedgesText2 = "• Leaves are also long and narrow but don't have ligules  and auricles"
        val sedgesText3 = "• Leaf veins are also parallel but the leaf sheaths are continuous around the stem"
        val sedgesText4 = "• Stems are triangular in shape and have no nodes and internodes"

        // Set the provided text to the TextView
        sedges1.text = sedgesText1
        sedges2.text = sedgesText2
        sedges3.text = sedgesText3
        sedges4.text = sedgesText4

        // broadleaves
        // Find the TextView by its ID within the fragment's view
        val broad1 = view.findViewById<TextView>(R.id.broad1)
        val broad2 = view.findViewById<TextView>(R.id.broad2)
        val broad3 = view.findViewById<TextView>(R.id.broad3)
        val broad4 = view.findViewById<TextView>(R.id.broad4)
        val broad5 = view.findViewById<TextView>(R.id.broad5)

        // The provided text
        val broadText1 = "• Members belong to many families"
        val broadText2 = "• Leaves are fully expanded with netted veins"
        val broadText3 = "• Leaves. flowers, stems, and branches are broadly arranged in various shapes, colors and structures"
        val broadText4 = "• Stems are called culms with well-defined noded and internodes"
        val broadText5 = "• Stems are round and hollow inside"

        // Set the provided text to the TextView
        broad1.text = broadText1
        broad2.text = broadText2
        broad3.text = broadText3
        broad4.text = broadText4
        broad5.text = broadText5


    }

}