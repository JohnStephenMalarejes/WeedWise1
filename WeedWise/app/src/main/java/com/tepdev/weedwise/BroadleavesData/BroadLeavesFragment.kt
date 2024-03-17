// BroadLeavesFragment.kt
package com.tepdev.weedwise.BroadleavesData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tepdev.weedwise.BroadleavesContract
import com.tepdev.weedwise.R
import com.tepdev.weedwise.Weed
import com.tepdev.weedwise.WeedDatabaseHelper

class BroadLeavesFragment : Fragment() {

    private lateinit var dbHelper: WeedDatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_broad_leaves, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbHelper = WeedDatabaseHelper(requireContext())

        // Fetch data from the database
        val items = dbHelper.getAllWeedsFromTable(BroadleavesContract.BroadleavesEntry.TABLE_NAME)

        // Initialize RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycle_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = BroadleavesAdapter(requireContext(), items)
    }
}
