package com.example.togglebutton

import android.os.Bundle
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toggleButton = findViewById<ToggleButton>(R.id.toggleButton)
        val textView = findViewById<TextView>(R.id.textView)

        toggleButton.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                textView.visibility = TextView.VISIBLE
            } else {
                textView.visibility = TextView.GONE
            }

        }
    }
}