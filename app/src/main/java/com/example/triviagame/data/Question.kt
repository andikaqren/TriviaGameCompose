package com.example.triviagame.data

data class Question(
    val question: String,
    val options: List<String>,
    val correctAnswer: String
)
