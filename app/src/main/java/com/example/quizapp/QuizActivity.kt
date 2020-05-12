package com.example.quizapp

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.QuizActivity
import java.util.*

class QuizActivity : AppCompatActivity() {
    private var textViewQuestion: TextView? = null
    private var textViewScore: TextView? = null
    private var textViewQuestionCount: TextView? = null
    private var rbGroup: RadioGroup? = null
    private var rb1: RadioButton? = null
    private var rb2: RadioButton? = null
    private var rb3: RadioButton? = null
    private var buttonConfirmNext: Button? = null
    private var textColorDefaultRb: ColorStateList? = null
    private var questions: List<Question?>? = null
    private var questionCounter = 0
    private var questionCountTotal = 0
    private var currentQuestion: Question? = null
    private var score = 0
    private var answered = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        textViewQuestion = findViewById(R.id.text_view_question)
        textViewScore = findViewById(R.id.text_view_score)
        textViewQuestionCount = findViewById(R.id.text_view_question_count)
        rbGroup = findViewById(R.id.radio_group)
        rb1 = findViewById(R.id.radio_button1)
        rb2 = findViewById(R.id.radio_button2)
        rb3 = findViewById(R.id.radio_button3)
        buttonConfirmNext = findViewById(R.id.button_confirm_next)
        textColorDefaultRb = rb1?.getTextColors()
        val dataProvider = DataProvider()
        questions = dataProvider.questions
        questionCountTotal = questions!!.size
        Collections.shuffle(questions)
        showNextQuestion()
        buttonConfirmNext?.setOnClickListener(View.OnClickListener {
            if (!answered) {
                if (rb1?.isChecked!! || rb2?.isChecked!! || rb3?.isChecked!!) {
                    checkAnswer()
                } else {
                    Toast.makeText(this@QuizActivity, "Wybierz odpowiedz", Toast.LENGTH_SHORT).show()
                }
            } else {
                showNextQuestion()
            }
        })
    }

    private fun showNextQuestion() {
        rb1!!.setTextColor(textColorDefaultRb)
        rb2!!.setTextColor(textColorDefaultRb)
        rb3!!.setTextColor(textColorDefaultRb)
        rbGroup!!.clearCheck()
        if (questionCounter < questionCountTotal) {
            currentQuestion = questions!![questionCounter]
            textViewQuestion?.text = currentQuestion?.question;
            rb1?.text = currentQuestion?.option1
            rb2?.text =currentQuestion?.option2
            rb3?.text =currentQuestion?.option3
            questionCounter++
            textViewQuestionCount!!.text = "Pytanie: $questionCounter/$questionCountTotal"
            answered = false
            buttonConfirmNext!!.text = "Potiwerdz"
        } else {
            finishQuiz()
        }
    }

    private fun finishQuiz() {
        finish()
    }

    private fun checkAnswer() {
        answered = true
        val rbSelected = findViewById<RadioButton>(rbGroup!!.checkedRadioButtonId)
        val answerNr = rbGroup!!.indexOfChild(rbSelected) + 1
        if (answerNr == currentQuestion?.answerNr) {
            score++
            textViewScore!!.text = "Score: $score"
        }
        showSolution()
    }

    private fun showSolution() {
        rb1!!.setTextColor(Color.RED)
        rb2!!.setTextColor(Color.RED)
        rb3!!.setTextColor(Color.RED)
        when (currentQuestion?.answerNr) {
            1 -> {
                rb1!!.setTextColor(Color.GREEN)
                textViewQuestion!!.text = "Odpowiedz 1 jest poprawna"
            }
            2 -> {
                rb2!!.setTextColor(Color.GREEN)
                textViewQuestion!!.text = "Odpowiedz 2 jest poprawna"
            }
            3 -> {
                rb3!!.setTextColor(Color.GREEN)
                textViewQuestion!!.text = "Odpowiedz 3 jest poprawna"
            }
        }
        if (questionCounter < questionCountTotal) {
            buttonConfirmNext!!.text = "Następne"
        } else {
            buttonConfirmNext!!.text = "Koniec"
        }
    }
}