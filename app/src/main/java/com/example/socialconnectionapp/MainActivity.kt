package com.example.socialconnectionapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etTimeOfDay = findViewById<EditText>(R.id.etTimeOfDay)
        val btnGetSpark = findViewById<Button>(R.id.btnGetSpark)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val tvSuggestion = findViewById<TextView>(R.id.tvSuggestion)

        btnGetSpark.setOnClickListener {
            val input = etTimeOfDay.text.toString().trim().lowercase()

            android.util.Log.d("SocialSpark", "User entered: $input")

            val suggestion = if (input == "morning") {
                "Send a Good morning text to a family member!"
            } else if (input == "mid-morning") {
                "Reach out to a colleague with a quick Thank you!"
            } else if (input == "afternoon") {
                "Share a funny meme with a friend!"
            } else if (input == "afternoon snack time") {
                "Send a quick thinking of you message!"
            } else if (input == "evening") {
                "Call a friend or relative for a 5 minute catch up!"
            } else if (input == "after dinner" || input == "night") {
                "Leave a thoughtful comment on a friend's post!"
            } else {
                " Please enter a valid time of day (e.g. Morning, Afternoon, Evening)"
            }

            tvSuggestion.text = suggestion
            android.util.Log.d("SocialSpark", "Suggestion shown: $suggestion")
        }

        btnReset.setOnClickListener {
            etTimeOfDay.text.clear()
            tvSuggestion.text = ""
            android.util.Log.d("SocialSpark", "App was reset")
        }
    }
}