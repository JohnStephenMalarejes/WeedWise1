package com.tepdev.weedwise.SedgesData

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.bold
import androidx.recyclerview.widget.RecyclerView
import com.tepdev.weedwise.R
import com.tepdev.weedwise.Weed

class SedgesAdapter (private val context: Context, private val items: List<Weed>) :
    RecyclerView.Adapter<SedgesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageResource)
        holder.textView.text = item.scientificName

        holder.itemView.setOnClickListener {
            val intent = Intent("com.tepdev.weedwise.action.VIEW_SEDGES")
            intent.putExtra("imageResId", item.imageResource)
            intent.putExtra("description", item.scientificName)
            intent.putExtra("localName", item.localName)
            intent.putExtra("family", item.family)
            intent.putExtra("eppoCode", item.eppoCode)
            intent.putExtra("classification", item.classification)
            intent.putExtra("growsIn", item.growsIn)
            intent.putExtra("lifeCyle", item.lifeCycle)
            intent.putExtra("reproduction", item.reproduction)
            intent.putExtra("characteristic", item.characteristics)
            intent.putExtra("impact", item.impact)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
}
