package com.example.triviagame

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviagame.ui.theme.TriviaGameTheme

class MainMenu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaGameTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Main Menu",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            },
                            backgroundColor = Color.White,
                            elevation = 4.dp
                        )
                    }
                ) {
                    MainMenu(
                        onQuizClicked = {
                            val intent = Intent(this, MainActivity::class.java)
                            this.startActivity(intent)
                        },
                        onAchievementClicked = {
                            val intent = Intent(this, AchievementActivity::class.java)
                            this.startActivity(intent)
                        },
                        onStoreClicked = {
                            val intent = Intent(this, StoreActivity::class.java)
                            this.startActivity(intent)
                        },
                        onOtherMenuClicked = { /* Handle other menu click */ }
                    )
                }
            }
        }
    }
}

@Composable
fun MainMenu(
    onQuizClicked: () -> Unit,
    onAchievementClicked: () -> Unit,
    onStoreClicked: () -> Unit,
    onOtherMenuClicked: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.brain),
            contentDescription = "Main Background",
            modifier = Modifier
                .width(100.dp)
                .height(200.dp),
            contentScale = ContentScale.Fit
        )

        MenuOption(
            text = "Quiz",
            painter = painterResource(id = R.drawable.ic_home),
            onClick = onQuizClicked
        )

        MenuOption(
            text = "Achievement",
            painter = painterResource(id = R.drawable.ic_home),
            onClick = onAchievementClicked
        )

        MenuOption(
            text = "Store",
            painter = painterResource(id = R.drawable.ic_home),
            onClick = onStoreClicked
        )

        MenuOption(
            text = "Others",
            painter = painterResource(id = R.drawable.ic_home),
            onClick = onOtherMenuClicked
        )
    }
}

@Composable
fun MenuOption(
    text: String,
    painter: Painter,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = text,
            tint = Color.Black,
            modifier = Modifier.size(32.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.subtitle1
        )
    }
}
