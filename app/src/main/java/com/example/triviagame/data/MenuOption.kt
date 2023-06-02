package com.example.triviagame.data

import androidx.compose.ui.graphics.painter.Painter

data class MenuOption(
    val text: String,
    val painter: Painter,
    val onClick: () -> Unit
)