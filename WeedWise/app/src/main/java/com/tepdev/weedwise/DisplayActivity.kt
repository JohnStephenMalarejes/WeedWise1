package com.tepdev.weedwise

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_display.*
import kotlinx.android.synthetic.main.activity_display.toolbar
import kotlinx.android.synthetic.main.recognition_display.*

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        // Get the image resource and text from the Intent's extras
        val imageResId = intent.getIntExtra("imageResource", R.drawable.logo)
        val displayText = intent.getStringExtra("displayText")

        // Set the image and text in the DisplayActivity
        imageView.setImageResource(imageResId)
        textView.text = displayText

        toolbar.title = ""

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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