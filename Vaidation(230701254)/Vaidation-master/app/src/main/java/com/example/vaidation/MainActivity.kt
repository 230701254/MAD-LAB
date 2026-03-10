package com.example.validation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etID = findViewById<EditText>(R.id.etID)
        val btnValidate = findViewById<Button>(R.id.btnValidate)

        btnValidate.setOnClickListener {

            val username = etUsername.text.toString().trim()
            val id = etID.text.toString().trim()

            // i) Both fields should not be empty
            if (username.isEmpty() || id.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // ii) Username should contain alphabets only
            if (!username.matches(Regex("^[a-zA-Z]+$"))) {
                Toast.makeText(this, "Username must contain alphabets only", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // iii) ID should be numeric and exactly 4 digits
            if (!id.matches(Regex("^\\d{4}$"))) {
                Toast.makeText(this, "ID must be exactly 4 digits", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show()
        }
    }
}