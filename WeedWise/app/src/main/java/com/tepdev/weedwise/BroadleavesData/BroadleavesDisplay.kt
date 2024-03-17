package com.tepdev.weedwise.BroadleavesData

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.tepdev.weedwise.ImageViewActivity
import com.tepdev.weedwise.R
import kotlinx.android.synthetic.main.recognition_display.*

class BroadleavesDisplay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.broadleaves_layout)

        val imageResId = intent.getIntExtra("imageResId", 0)
        val description = intent.getStringExtra("description")
        val broadleavesLocal = intent.getStringExtra("localName")
        val broadleavesFamily = intent.getStringExtra("family")
        val broadleavesEppoCode = intent.getStringExtra("eppoCode")
        val broadleavesClassification = intent.getStringExtra("classification")
        val broadleavesGrows = intent.getStringExtra("growsIn")
        val broadleavesLifeCycle = intent.getStringExtra("lifeCyle")
        val broadleavesReproduction = intent.getStringExtra("reproduction")
        val broadleavesCharacteristic = intent.getStringExtra("characteristic")
        val broadleavesImpact = intent.getStringExtra("impact")

        val imageView = findViewById<ImageView>(R.id.detailImageView)
        val textView = findViewById<TextView>(R.id.detailTextView)
        val localName = findViewById<TextView>(R.id.local)
        val family = findViewById<TextView>(R.id.family)
        val eppoCode = findViewById<TextView>(R.id.eppoCode)
        val classification = findViewById<TextView>(R.id.morphological)
        val grows = findViewById<TextView>(R.id.grows)
        val lifeCyle = findViewById<TextView>(R.id.lifeCycle)
        val reproduction = findViewById<TextView>(R.id.reproduction)
        val characteristics = findViewById<TextView>(R.id.characteristic)
        val impact = findViewById<TextView>(R.id.impact)

        imageView.setImageResource(imageResId)
        textView.text = description
        localName.text = "Local Name: $broadleavesLocal"
        family.text = "Family: $broadleavesFamily"
        eppoCode.text = "EPPO Code: $broadleavesEppoCode"
        classification.text = "Morphological Classification: $broadleavesClassification"
        grows.text = Html.fromHtml("<b>Grows in:</b> $broadleavesGrows")
        lifeCyle.text = Html.fromHtml("<b>Life Cycle:</b> $broadleavesLifeCycle")
        reproduction.text = Html.fromHtml("<b>Means of Reproduction:</b> $broadleavesReproduction")
        characteristics.text = Html.fromHtml("<b>Distinguishing Characteristics:</b> $broadleavesCharacteristic")
        impact.text = Html.fromHtml("<b>Reported impacts on rice:</b> $broadleavesImpact")

        toolbar.title = ""

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imageView.setOnClickListener {
            // Create an Intent to navigate to ImageViewActivity
            val intent = Intent(this, ImageViewActivity::class.java)

            // Pass the image resource ID to ImageViewActivity
            intent.putExtra("imageResource", imageResId)

            // Start ImageViewActivity
            startActivity(intent)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Handle the back button click
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
