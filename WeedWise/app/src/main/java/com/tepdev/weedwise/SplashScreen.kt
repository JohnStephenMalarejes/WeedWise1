package com.tepdev.weedwise

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val rootView = findViewById<View>(android.R.id.content)

        rootView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                // Touch event detected, proceed to the next screen
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            true
        }
    }
}
