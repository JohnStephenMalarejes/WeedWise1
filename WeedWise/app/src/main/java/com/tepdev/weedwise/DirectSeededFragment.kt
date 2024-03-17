package com.tepdev.weedwise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class DirectSeededFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_direct_seeded, container, false)

        // Find your buttons
        val btn24d = view.findViewById<Button>(R.id.btn_24d)
        val btnBensulfuron = view.findViewById<Button>(R.id.btn_bensulfuron)
        val btnBentazon = view.findViewById<Button>(R.id.btn_bentazon)
        val btnBispyribac = view.findViewById<Button>(R.id.btn_bispyribac)
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
            val reminders = "Apply on saturated soil or reduce water to expose weeds. Re-flood within 2-3 days after spraying"
            showReminderDialog(title, time, rate, reminders)
        }

        btnBensulfuron.setOnClickListener {
            val title = "Bensulfuron methyl"
            val time = "4-8 DAT"
            val rate = "500-700 g/ha"
            val reminders = "Work best with standing water that should be retained for at least 4 days. Compatible with other herbicides. Spray volume is 80 160 L/ha"
            showReminderDialog(title, time, rate, reminders)
        }

        btnBentazon.setOnClickListener {
            val title = "Bentazon"
            val time = "weeds at 2 to10-leaf stage"
            val rate = "2.0 L/ha"
            val reminders = "Apply on saturated soil or reduce water to expose weeds. Spray volume is 500 L/ha. "
            showReminderDialog(title, time, rate, reminders)
        }

        btnBispyribac.setOnClickListener {
            val title = "Bispyribac sodium"
            val time = "20-30 DAS"
            val rate = "250 ml/ha"
            val reminders = "Before spraying, drain excess water until the half part of target weeds appears. Re-irrigate within 1-3 days after spraying."
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