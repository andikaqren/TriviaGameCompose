package com.example.triviagame.data

import android.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class StoreItem(
    val name: String,
    val icon: Painter,
    val price: String
)