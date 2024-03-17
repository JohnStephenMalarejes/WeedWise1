package com.tepdev.weedwise

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.text.Html
import android.view.View
import kotlinx.android.synthetic.main.recognition_display.*
import java.util.Locale


class ResultActivity : AppCompatActivity(), OnInitListener {

    // Declare textToSpeech as a class-level property
    private lateinit var textToSpeech: TextToSpeech
    private var imageResourceId: Int = 0

    // Declare class-level properties for the labels
    private lateinit var englishName: String
    private lateinit var localName: String
    private lateinit var familyName: String
    private lateinit var eppoCode: String
    private lateinit var morphological: String
    private lateinit var growsIn: String
    private lateinit var lifeCycle: String
    private lateinit var reproduction: String
    private lateinit var characteristic: String
    private lateinit var impact: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recognition_display)

        val imageView = findViewById<ImageView>(R.id.capturedImageView)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val englishNameTextView = findViewById<TextView>(R.id.englishTextView)
        val localNameTextView = findViewById<TextView>(R.id.localTextView)
        val familyNameTextView = findViewById<TextView>(R.id.familyTextView)
        val eppoCodeTextView = findViewById<TextView>(R.id.eppoCodeTextView)
        val morphologicalTextView = findViewById<TextView>(R.id.morphologicalTextView)
        val growsTextView = findViewById<TextView>(R.id.growsTextView)
        val lifeCycleTextView = findViewById<TextView>(R.id.lifeCycleTextView)
        val reproductionTextView = findViewById<TextView>(R.id.reproductionTextView)
        val characteristicTextView = findViewById<TextView>(R.id.characteristicTextView)
        val impactTextView = findViewById<TextView>(R.id.impactTextView)

        val notRecognizedTextView = findViewById<TextView>(R.id.notRecognizedTextView)


        // Retrieve data from the Intent
        val imageResourceId = intent.getIntExtra("imageResourceId", 0)
        val result = intent.getStringExtra("result")
        englishName = intent.getStringExtra("englishName") ?: ""
        localName = intent.getStringExtra("localName") ?: ""
        familyName = intent.getStringExtra("family") ?: ""
        eppoCode = intent.getStringExtra("eppoCode") ?: ""
        morphological = intent.getStringExtra("morphological") ?: ""
        growsIn = intent.getStringExtra("growsIn") ?: ""
        lifeCycle = intent.getStringExtra("lifeCycle") ?: ""
        reproduction = intent.getStringExtra("reproduction") ?: ""
        characteristic = intent.getStringExtra("characteristic") ?: ""
        impact = intent.getStringExtra("impact") ?: ""


        if (result == "Not Recognized as Weed") {
            // Show the "Not Recognized as Weed" message
            notRecognizedTextView.visibility = View.VISIBLE
        } else {
            // Load and display the recognized weed information
            notRecognizedTextView.visibility = View.GONE
            // ...
            // Other code to display recognized weed information
        }

        // Load the image resource and set it to the ImageView
        if (imageResourceId != 0) {
            imageView.setImageResource(imageResourceId)
        }
        imageView.setOnClickListener {
            // Create an Intent to navigate to ImageViewActivity
            val intent = Intent(this, ImageViewActivity::class.java)

            // Pass the image resource ID to ImageViewActivity
            intent.putExtra("imageResource", imageResourceId)

            // Start ImageViewActivity
            startActivity(intent)
        }


        resultTextView.text = result
        englishNameTextView.text = "English Name: $englishName"
        localNameTextView.text = "Local Name: $localName"
        familyNameTextView.text = "Family: $familyName"
        eppoCodeTextView.text = "EPPO Code: $eppoCode"
        morphologicalTextView.text = "Morphological Classification: $morphological"
        growsTextView.text = Html.fromHtml("<b>Grows in:</b> $growsIn")
        lifeCycleTextView.text = Html.fromHtml("<b>Life Cycle:</b> $lifeCycle")
        reproductionTextView.text = Html.fromHtml("<b>Means of Reproduction:</b> $reproduction")
        characteristicTextView.text = Html.fromHtml("<b>Distinguishing Characteristics:</b> $characteristic")
        impactTextView.text = Html.fromHtml("<b>Reported impacts on rice:</b> $impact")

        toolbar.title = ""
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Initialize the Text-to-Speech engine and set the speech rate (adjust as needed)
        textToSpeech = TextToSpeech(this, this)
        val speechRate = 0.7f // You can adjust this value to make it slower
        textToSpeech.setSpeechRate(speechRate)

        textToSpeech.speak(resultTextView.text.toString(), TextToSpeech.QUEUE_FLUSH, null, null)
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

    fun readLabels(view: View) {
        if (textToSpeech.isSpeaking) {
            textToSpeech.stop()
        } else {
            val labelsToRead = """
            English Name: $englishName
            Local Name: $localName
            Family: $familyName
            EPPO Code: $eppoCode
            Morphological Classification: $morphological
            Grows in: $growsIn
            Life Cycle: $lifeCycle
            Means of Reproduction: $reproduction
            Distinguishing Characteristics: $characteristic
            Reported impacts on rice: $impact
        """.trimIndent()

            // Speak the labels' text using Text-to-Speech
            textToSpeech.speak(labelsToRead, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }


    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // Set the language for TTS (you can change the locale as needed)
            val locale = Locale.US
            val result = textToSpeech.setLanguage(locale)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Handle the case where the language is not supported
            } else {
                // Read the result using Text-to-Speech
                textToSpeech.speak(resultTextView.text.toString(), TextToSpeech.QUEUE_FLUSH, null, null)
            }
        } else {
            // Handle initialization error
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release Text-to-Speech engine
        textToSpeech.shutdown()
    }

}
