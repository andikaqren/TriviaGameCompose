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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviagame.ui.theme.TriviaGameTheme

class MainMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaGameTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Icon(
                                    painter = painterResource(id = R.drawable.lifestyles),
                                    contentDescription = "Energy Icon",
                                    tint = Color.Unspecified,
                                    modifier = Modifier.size(24.dp)
                                )
                                Text(
                                    text = "Main Menu",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily(Font(R.font.modern))
                                    )
                                )

                            },
                            actions = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(end = 16.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.energy_drink),
                                        contentDescription = "Energy Icon",
                                        tint = Color.Unspecified,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Text(
                                        text = "99999",
                                        color = Color.Green,
                                        style = TextStyle(
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font(R.font.games))
                                        )


                                    )
                                }
                            },
                            backgroundColor = Color.White,
                            elevation = 4.dp
                        )
                    }
                ) {
                    MainMenu(1000,
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
                        onQuestClicked = {
                            val intent = Intent(this, QuestActivity::class.java)
                            this.startActivity(intent)
                        },
                        onLeaderboardClicked = {
                            val intent = Intent(this, LeaderboardActivity::class.java)
                            this.startActivity(intent)
                        },
                        onOtherMenuClicked = {
                            val intent = Intent(this, WorkoutActivity::class.java)
                            this.startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MainMenu(
    coinCount: Int,
    onQuizClicked: () -> Unit,
    onAchievementClicked: () -> Unit,
    onStoreClicked: () -> Unit,
    onQuestClicked: () -> Unit,
    onLeaderboardClicked: () -> Unit,
    onOtherMenuClicked: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.lifestyles),
                contentDescription = "Main Background",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Coin Icon",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = coinCount.toString(),
                    color = Color.White,
                    style = MaterialTheme.typography.body1
                )
            }
        }

        MenuOption(
            text = "Quiz",
            painter = painterResource(id = R.drawable.quiz),
            onClick = onQuizClicked
        )

        MenuOption(
            text = "Achievement",
            painter = painterResource(id = R.drawable.badge),
            onClick = onAchievementClicked
        )

        MenuOption(
            text = "Store",
            painter = painterResource(id = R.drawable.store),
            onClick = onStoreClicked
        )

        MenuOption(
            text = "Daily Quest",
            painter = painterResource(id = R.drawable.target),
            onClick = onQuestClicked
        )

        MenuOption(
            text = "Leaderboard",
            painter = painterResource(id = R.drawable.goals),
            onClick = onLeaderboardClicked
        )

        MenuOption(
            text = "Workout",
            painter = painterResource(id = R.drawable.workout),
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
            painter = painter,
            contentDescription = text,
            tint = Color.Unspecified,
            modifier = Modifier.size(32.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.subtitle1
        )
    }
}
