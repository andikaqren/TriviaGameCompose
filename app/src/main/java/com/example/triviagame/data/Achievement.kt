package com.example.triviagame.data

import androidx.annotation.DrawableRes

data class Achievement(
    val title: String,
    val description: String,
    @DrawableRes val iconRes: Int
)