@file:OptIn(ExperimentalFoundationApi::class)

package com.example.triviagame

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviagame.data.MenuOption
import com.example.triviagame.ui.theme.TriviaGameTheme

class MainMenuActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
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
                                        color = colorResource(id = R.color.blacky),
                                        fontFamily = FontFamily(
                                            Font(R.font.modern),
                                        )
                                    ),
                                    modifier = Modifier.padding(start = 16.dp)
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
                                        color = colorResource(id = R.color.blacky),
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
    val menuOptions = listOf(
        MenuOption(
            text = "Quiz",
            painter = painterResource(id = R.drawable.quiz),
            onClick = onQuizClicked
        ),
        MenuOption(
            text = "Achievement",
            painter = painterResource(id = R.drawable.badge),
            onClick = onAchievementClicked
        ),
        MenuOption(
            text = "Store",
            painter = painterResource(id = R.drawable.store),
            onClick = onStoreClicked
        ),
        MenuOption(
            text = "Daily Quest",
            painter = painterResource(id = R.drawable.target),
            onClick = onQuestClicked
        ),
        MenuOption(
            text = "Leaderboard",
            painter = painterResource(id = R.drawable.goals),
            onClick = onLeaderboardClicked
        ),
        MenuOption(
            text = "Workout",
            painter = painterResource(id = R.drawable.workout),
            onClick = onOtherMenuClicked
        )
    )

    val rows = menuOptions.chunked(2)

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        items(rows.size) { rowIndex ->
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (menu in rows[rowIndex]) {
                    Box(
                        modifier = Modifier
                            .clickable { menu.onClick() }
                            .padding(16.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(72.dp)
                                    .background(
                                        color = colorResource(id = R.color.blue),
                                        shape = CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = menu.painter,
                                    contentDescription = menu.text,
                                    modifier = Modifier.size(48.dp),
                                    tint = Color.Unspecified
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = menu.text,
                                style = MaterialTheme.typography.subtitle1,
                                color = colorResource(id = R.color.blacky),
                                fontFamily = FontFamily(Font(R.font.modern))
                            )
                        }
                    }
                }
            }
        }
    }
}







