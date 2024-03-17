package com.tepdev.weedwise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class TransplantedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_transplanted, container, false)

        // Find your buttons
        val btn24d = view.findViewById<Button>(R.id.btn_24d)
        val btnBensulfuron = view.findViewById<Button>(R.id.btn_bensulfuron)
        val btnButachlor1 = view.findViewById<Button>(R.id.btn_butachlor1)
        val btnButachlor2 = view.findViewById<Button>(R.id.btn_butachlor2)
        val btnButachlor3 = view.findViewById<Button>(R.id.btn_butachlor3)
        val btnButachlor4 = view.findViewById<Button>(R.id.btn_butachlor4)
        val btnPropanil = view.findViewById<Button>(R.id.btn_propanil)
        val btnFenoxaprop = view.findViewById<Button>(R.id.btn_fenoxaprop)
        val btnMcpa = view.findViewById<Button>(R.id.btn_mcpa)
        val btnOxadiazon = view.findViewById<Button>(R.id.btn_oxadiazon)
        val btnPretilachlor = view.findViewById<Button>(R.id.btn_pretilachlor)

        // Set click listeners for each button
        btn24d.setOnClickListener {
            val title = "2, 4-D"
            val time = "21-28 DAT"
            val rate = "1.0-1.5 L/ha"
            val reminders = "Reduce water level to expose weeds before application.\n Re-flood within 2-3 DAA."
            showReminderDialog(title, time, rate, reminders)
        }

        btnBensulfuron.setOnClickListener {
            val title = "Bensulfuron methyl"
            val time = "4-8 DAT"
            val rate = "500-700 g/ha"
            val reminders = "Work best with standing water that should be retained for at least 4 days. Compatible with other herbicides. Spray volume is 80 160 L/ha"
            showReminderDialog(title, time, rate, reminders)
        }

        btnButachlor1.setOnClickListener {
            val title = "Butachlor"
            val time = "0-4 DAT (Wetbed)"
            val rate = "1.0 L/ha"
            val reminders = "Apply on field with 3-5 cm water. Maintain water until 4-5 DAA for better weed control. If applied on saturated soil, Irrigate immediately; maintain 2-3 cm water for 4 6 DAA"
            showReminderDialog(title, time, rate, reminders)
        }

        btnButachlor2.setOnClickListener {
            val title = "Butachlor"
            val time = "2-5 DAT"
            val rate = "1.0 L/ha"
            val reminders = "Apply on moist and puddled soil. Control water normally after applying without submerging seedlings. Spray volume is 200 L/ha"
            showReminderDialog(title, time, rate, reminders)
        }
        btnButachlor3.setOnClickListener {
            val title = "Butachlor"
            val time = "2-4 DAT"
            val rate = "20 kg/ha"
            val reminders = "Apply on field with 3-5 cm water. Maintain water until 4-5 DAA for better weed control."
            showReminderDialog(title, time, rate, reminders)
        }
        btnButachlor4.setOnClickListener {
            val title = "Butachlor"
            val time = "2-4 DAT (Dapog)"
            val rate = "1.0 L/ha"
            val reminders = "Apply on field with 3-5 cm water. Maintain water until 4-5 DAA for better weed control. If applied on saturated soil, Irrigate immediately; maintain 2-3 cm water for 4 6 DAA"
            showReminderDialog(title, time, rate, reminders)
        }

        btnPropanil.setOnClickListener {
            val title = "Butachlor + Propanil"
            val time = "6-10 DAT"
            val rate = "1.5-2.0 L/ha"
            val reminders = "Apply on saturated soil. Flood field 1-3 DAA; spray volume is 200 L/ha"
            showReminderDialog(title, time, rate, reminders)
        }
        btnFenoxaprop.setOnClickListener {
            val title = "Fenoxaprop P- ethyl + ethoxysulfuron"
            val time = "15-20 DAT"
            val rate = "500 ml/ha"
            val reminders = "Flush field or reduce water to expose the grass weeds. Rice plants must not submerged after herbicide application"
            showReminderDialog(title, time, rate, reminders)
        }
        btnMcpa.setOnClickListener {
            val title = "MCPA"
            val time = "25-30 DAT"
            val rate = "1.0 L/ha"
            val reminders = "Reduce water to expose weeds. Redflood with 2-3 DAA."
            showReminderDialog(title, time, rate, reminders)
        }
        btnOxadiazon.setOnClickListener {
            val title = "Oxadiazon"
            val time = "3-5 DAT"
            val rate = "1.5-2.0 L/ha"
            val reminders = "Works best with standing water or at least moist soil even after application; compatible with commonly used herbicides. Spray volume is 500-600 L/ha. Can be used in upland or dryseeded rice."
            showReminderDialog(title, time, rate, reminders)
        }
        btnPretilachlor.setOnClickListener {
            val title = "Butachlor + Propanil"
            val time = "0-3 DAT"
            val rate = "1.0 L/ha"
            val reminders = "Apply on saturated soil. Spray volume is 160-224 L/ha"
            showReminderDialog(title, time, rate, reminders)
        }



        return view
    }

    private fun showReminderDialog(title: String, time: String, rate: String, reminders: String) {
        val dialogFragment = ReminderDialog.newInstance(title, time, rate, reminders)
        dialogFragment.show(parentFragmentManager, "ReminderDialogFragment")
    }
}
