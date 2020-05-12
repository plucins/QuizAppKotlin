package com.example.quizapp

import java.util.*

class DataProvider {
    val questions: List<Question>
        get() {
            val questions: MutableList<Question> = ArrayList()
            questions.add(Question("Grzie ropoczął się wirus?", "Polska", "USA", "Chiny", 3))
            questions.add(Question("Czy uda nam nie przeżyć", "Tak", "Nie", "Nie wiem", 3))
            questions.add(Question("Jaka musi byc odlełość między osobami?", "1m", "2m", "4m", 2))
            questions.add(Question("Czy możesz zorganizowac przyjęcie na 13 osób?", "Nie", "Tak", "Nie wiem", 1))
            return questions
        }
}