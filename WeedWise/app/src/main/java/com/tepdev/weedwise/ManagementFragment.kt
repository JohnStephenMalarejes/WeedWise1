package com.tepdev.weedwise

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_management.*

class ManagementFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_management, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set click listeners for your buttons
        btnSeeds.setOnClickListener { showImageAndText(R.drawable.seeds, "Using clean seeds is a fundamental practice in agriculture and horticulture. It involves selecting and planting seeds that are free from contaminants, diseases, and impurities. Clean seeds ensure the healthy growth of crops and plants, leading to better yields and overall quality.") }
        btnSanitation.setOnClickListener { showImageAndText(R.drawable.sanitation, "Practice Field Sanitation in rice farming is a crucial technique focused on maintaining the health of the crop. It involves practices like removing crop residues after harvest to prevent pests and diseases, cleaning and disinfecting farm equipment to avoid contamination, and using certified disease-free seeds. Crop rotation, monitoring for disease signs, and using resistant varieties are also part of this practice. Field sanitation ensures cleaner, healthier rice fields and higher crop yields") }
        btnPreparation.setOnClickListener { showImageAndText(R.drawable.preparation, "Practicing through land preparation, rice farmers create an environment that minimizes weed pressure, optimizes nutrient availability, and promotes healthy rice growth. This proactive approach is a cornerstone of successful rice farming, resulting in improved crop yields and overall agricultural sustainability.") }
        btnManagement.setOnClickListener { showImageAndText(R.drawable.management, "Practicing good water management in rice farming is essential for achieving healthy and productive crops. This practice involves careful control of water levels in rice fields, tailored to each growth stage. It prevents waterlogging, conserves water, and disrupts weed growth cycles. Modern technologies and precise irrigation systems enhance efficiency, while integrated weed management techniques further reduce weed competition. In summary, effective water management ensures optimal crop growth and supports sustainable rice farming.") }
        btnWeeding.setOnClickListener { showImageAndText(R.drawable.weeding, "Manual and mechanical weeding in rice farming involves the careful removal of weeds either by hand or machinery. This practice targets weed seedlings and mature weeds during critical growth stages of rice plants, minimizing competition for resources. It ensures healthier rice crops and increased yields, making it a key component of effective weed management.") }
        btnControl.setOnClickListener { showImageAndText(R.drawable.control, "Using biological control in weed management is a sustainable and eco-friendly approach that leverages natural predators or organisms to control weed populations. This practice involves the introduction of biocontrol agents like insects or microbes that target specific weeds, reducing the need for chemical herbicides. Integrated into weed management plans, biological control is an effective, environmentally responsible strategy that benefits crop production and the ecosystem.") }
        btnHerbicides.setOnClickListener { showImageAndText(R.drawable.herb, "Using herbicides is a common and effective method for weed control in agriculture. These chemical substances, available in various formulations, target and eliminate unwanted weeds, reducing competition with crops. Proper timing and dosage are crucial for effectiveness, and responsible application practices protect the environment and human health. When used judiciously and in combination with other weed management techniques, herbicides contribute to enhanced crop yields and sustainable agriculture.") }
    }

    private fun showImageAndText(imageResId: Int, buttonText: String) {
        // Create an Intent to open the DisplayActivity
        val intent = Intent(requireActivity(), DisplayActivity::class.java)

        // Put extras to pass image resource and text to the DisplayActivity
        intent.putExtra("imageResource", imageResId)
        intent.putExtra("displayText", buttonText)

        // Start the DisplayActivity
        startActivity(intent)
    }
}
