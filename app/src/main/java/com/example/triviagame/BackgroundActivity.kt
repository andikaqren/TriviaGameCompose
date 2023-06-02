package com.example.triviagame

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class BackgroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BackgroundScreen(listener = {
                val intent = Intent(this, MainMenuActivity::class.java)
                this.startActivity(intent)
            })
        }
    }

    @Preview
    @Composable
    fun BackgroundScreenPreview() {
        BackgroundScreen(listener = {
            val intent = Intent(this, MainMenuActivity::class.java)
            this.startActivity(intent)
        })
    }
}

@Composable
fun BackgroundScreen(listener: () -> Unit ){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.iv_background),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        FloatingActionButton(
            onClick =  listener ,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp).padding(bottom=45.dp), backgroundColor = Color.Green

        ) {
            Canvas(modifier = Modifier.size(60.dp)) {
                val radius = size.minDimension / 2f
                val brush = Brush.radialGradient(
                    listOf(Color(0xFF00FF00), Color.Transparent),
                    radius = radius,
                    center = center
                )
                drawCircle(brush = brush, radius = radius)
            }
            Icon(
                painter = painterResource(id = R.drawable.energy_drink),
                contentDescription = "Floating Button",
                tint = Color.Unspecified
            )
        }
    }
}
