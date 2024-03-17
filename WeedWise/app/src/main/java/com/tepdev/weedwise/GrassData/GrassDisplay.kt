package com.tepdev.weedwise.GrassData

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


class GrassDisplay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grass_layout)

        val imageResId = intent.getIntExtra("imageResId", 0)
        val description = intent.getStringExtra("description")
        val grassLocal = intent.getStringExtra("localName")
        val grassFamily = intent.getStringExtra("family")
        val grassEppoCode = intent.getStringExtra("eppoCode")
        val grassClassification = intent.getStringExtra("classification")
        val grassGrows = intent.getStringExtra("growsIn")
        val grassLifeCycle = intent.getStringExtra("lifeCyle")
        val grassReproduction = intent.getStringExtra("reproduction")
        val grassCharacteristic = intent.getStringExtra("characteristic")
        val grassImpact = intent.getStringExtra("impact")

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
        localName.text = grassLocal
        family.text = grassFamily
        eppoCode.text = grassEppoCode
        classification.text = grassClassification
        grows.text = Html.fromHtml("<b>Grows in:</b> $grassGrows")
        lifeCyle.text = Html.fromHtml("<b>Life Cycle:</b> $grassLifeCycle")
        reproduction.text = Html.fromHtml("<b>Means of Reproduction:</b> $grassReproduction")
        characteristics.text = Html.fromHtml("<b>Distinguishing Characteristics:</b> $grassCharacteristic")
        impact.text = Html.fromHtml("<b>Reported impacts on rice:</b> $grassImpact")

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


