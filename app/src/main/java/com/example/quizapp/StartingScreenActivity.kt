package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class StartingScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starting_screen)
        val buttonStartQuiz = findViewById<Button>(R.id.button_start_quiz)
        buttonStartQuiz.setOnClickListener { startQuiz() }
        val buttonStartChart = findViewById<Button>(R.id.button_start_chart)
        buttonStartChart.setOnClickListener { startChart() }
    }

    private fun startQuiz() {
        val intent = Intent(this@StartingScreenActivity, QuizActivity::class.java)
        startActivity(intent)
    }

    private fun startChart() {
        val intent = Intent(this@StartingScreenActivity, ChartActivity::class.java)
        startActivity(intent)
    }
}