package com.example.tempcalc

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tempInput = findViewById<EditText>(R.id.etTemperature)
        val btnCtoF = findViewById<Button>(R.id.btnCtoF)
        val btnFtoC = findViewById<Button>(R.id.btnFtoC)
        val resultText = findViewById<TextView>(R.id.tvResult)

        btnCtoF.setOnClickListener {
            val tempText = tempInput.text.toString()

            if (tempText.isEmpty()) {
                Toast.makeText(this, "Enter temperature", Toast.LENGTH_SHORT).show()
            } else {
                val celsius = tempText.toDouble()
                val fahrenheit = (celsius * 9/5) + 32
                resultText.text = "Result: %.2f °F".format(fahrenheit)
            }
        }

        btnFtoC.setOnClickListener {
            val tempText = tempInput.text.toString()

            if (tempText.isEmpty()) {
                Toast.makeText(this, "Enter temperature", Toast.LENGTH_SHORT).show()
            } else {
                val fahrenheit = tempText.toDouble()
                val celsius = (fahrenheit - 32) * 5/9
                resultText.text = "Result: %.2f °C".format(celsius)
            }
        }
    }
}