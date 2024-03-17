package com.tepdev.weedwise

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ReminderDialog  : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Retrieve the reminder details from arguments
        val title = requireArguments().getString(ARG_TITLE)
        val time = requireArguments().getString(ARG_TIME)
        val rate = requireArguments().getString(ARG_RATE)
        val reminders = requireArguments().getString(ARG_REMINDERS)

        // Build the reminder message
        val reminderMessage = StringBuilder()
        reminderMessage.append("Application \n")
        reminderMessage.append("Time: $time\n")
        reminderMessage.append("Rate: $rate\n\n")
        reminderMessage.append("Reminders:\n$reminders")

        // Create and configure the AlertDialog
        return AlertDialog.Builder(requireActivity())
            .setTitle(title)
            .setMessage(reminderMessage.toString())
            .setPositiveButton("OK") { _, _ ->
                // Dismiss the dialog when OK is clicked
                dismiss()
            }
            .create()
    }

    companion object {
        private const val ARG_TITLE = "title"
        private const val ARG_TIME = "time"
        private const val ARG_RATE = "rate"
        private const val ARG_REMINDERS = "reminders"

        fun newInstance(
            title: String,
            time: String,
            rate: String,
            reminders: String
        ): ReminderDialog {
            val fragment = ReminderDialog()
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            args.putString(ARG_TIME, time)
            args.putString(ARG_RATE, rate)
            args.putString(ARG_REMINDERS, reminders)
            fragment.arguments = args
            return fragment
        }
    }
}