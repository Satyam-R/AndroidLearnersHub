package com.example.quizz

object QuestionAnswer {
    var question = arrayOf(
        "1.  Who was the first president of India?",
        "2.  Which is the longest river in the world?",
        "3.  Who is the iron man of India?",
        "4.  Which is the tallest statue in the world?",
        "5.  Which is the largest ocean in the world?"
    )
    var choices = arrayOf(arrayOf("Zakir Husain", "Pratibha Patil", "Dr. Rajendra Prasad", "Dr. APJ Abdul Kalam"),
        arrayOf("The Ganga", "Amazon River", "Yellow River", "Nile"),
        arrayOf("Tony Stark", "Vallabhbhai Patel", "Mahatma Gandhi", "Subhash Chandra Bose"),
        arrayOf("Statue of Unity", "Statue of Liberty", "Sprng Temple Buddha", "Statue of Belief"),
        arrayOf("Pacific Ocean", "Indian Ocan", "Arctic Ocean", "Atlantic Ocean"))
    var correctAnswers = arrayOf(
        "Dr. Rajendra Prasad",
        "Nile",
        "Vallabhbhai Patel",
        "Statue of Unity",
        "Pacific Ocean"
    )
}