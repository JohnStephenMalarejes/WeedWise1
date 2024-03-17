package com.tepdev.weedwise.SedgesData

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

class SedgesDisplay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sedges_layout)

        val imageResId = intent.getIntExtra("imageResId", 0)
        val description = intent.getStringExtra("description")
        val sedgesLocal = intent.getStringExtra("localName")
        val sedgesFamily = intent.getStringExtra("family")
        val sedgesEppoCode = intent.getStringExtra("eppoCode")
        val sedgesClassification = intent.getStringExtra("classification")
        val sedgesGrows = intent.getStringExtra("growsIn")
        val sedgesLifeCycle = intent.getStringExtra("lifeCyle")
        val sedgesReproduction = intent.getStringExtra("reproduction")
        val sedgesCharacteristic = intent.getStringExtra("characteristic")
        val sedgesImpact = intent.getStringExtra("impact")

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
        localName.text = "Local Name: $sedgesLocal"
        family.text = "Family: $sedgesFamily"
        eppoCode.text = "EPPO Code: $sedgesEppoCode"
        classification.text = "Morphological Classification: $sedgesClassification"
        grows.text = Html.fromHtml("<b>Grows in:</b> $sedgesGrows")
        lifeCyle.text = Html.fromHtml("<b>Life Cycle:</b> $sedgesLifeCycle")
        reproduction.text = Html.fromHtml("<b>Means of Reproduction:</b> $sedgesReproduction")
        characteristics.text = Html.fromHtml("<b>Distinguishing Characteristics:</b> $sedgesCharacteristic")
        impact.text = Html.fromHtml("<b>Reported impacts on rice:</b> $sedgesImpact")

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
