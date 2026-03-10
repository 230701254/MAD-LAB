package com.example.digicafe

import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailInput = findViewById<EditText>(R.id.etEmail)
        val passwordInput = findViewById<EditText>(R.id.etPassword)
        val validateBtn = findViewById<Button>(R.id.btnValidate)

        validateBtn.setOnClickListener {

            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // 1️⃣ Check empty fields
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 2️⃣ Validate college email (example: must end with @college.edu)
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() ||
                !email.endsWith("@college.edu")) {

                Toast.makeText(this, "Enter valid college email ID", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 3️⃣ Password validation
            val passwordPattern =
                Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#\$%^&+=!]).{12,}$")

            if (!password.matches(passwordPattern)) {
                Toast.makeText(
                    this,
                    "Password must be 12+ chars with 1 uppercase, 1 number & 1 special symbol",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Validation Successful!", Toast.LENGTH_SHORT).show()
        }
    }
}