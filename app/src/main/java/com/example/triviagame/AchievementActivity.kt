package com.example.triviagame


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviagame.data.Achievement
import com.example.triviagame.ui.theme.TriviaGameTheme

class AchievementActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaGameTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Icon(
                                    painter = painterResource(id = R.drawable.badge),
                                    contentDescription = "Energy Icon",
                                    tint = Color.Unspecified,
                                    modifier = Modifier.size(24.dp)
                                )
                                Text(
                                    text = "Achievements",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily(Font(R.font.modern)),
                                        color = colorResource(id =R.color.blacky)
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
                    val achievements = listOf(
                        Achievement(
                            title = "First Milestone",
                            description = "You've completed your first milestone!",
                            iconRes = R.drawable.target
                        ),
                        Achievement(
                            title = "Healthy Eater",
                            description = "You've maintained a healthy diet for 30 days!",
                            iconRes = R.drawable.diet
                        ),
                        Achievement(
                            title = "Fitness Enthusiast",
                            description = "You've completed 100 workouts!",
                            iconRes = R.drawable.workout
                        ),
                        Achievement(
                            title = "Green Eater",
                            description = "You've maintained a plant-based diet for 30 days!",
                            iconRes = R.drawable.spinach
                        ),
                        Achievement(
                            title = "Marathon Runner",
                            description = "You've completed a full marathon!",
                            iconRes = R.drawable.finish_line
                        ),
                        Achievement(
                            title = "Yoga Master",
                            description = "You've mastered advanced yoga poses!",
                            iconRes = R.drawable.meditation
                        ),
                        Achievement(
                            title = "Healthy Chef",
                            description = "You've cooked 100 nutritious meals!",
                            iconRes = R.drawable.chef
                        ),
                        Achievement(
                            title = "Fitness Streak",
                            description = "You've exercised for 365 consecutive days!",
                            iconRes = R.drawable.dumbbell
                        )
                    )


                    AchievementLayout(achievements = achievements)
                }
            }
        }
    }
}

@Composable
fun AchievementLayout(achievements: List<Achievement>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(achievements) { achievement ->
                AchievementItem(achievement = achievement)
            }
        }
    }
}

@Composable
fun AchievementItem(achievement: Achievement) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        Icon(
            painter = painterResource(id = achievement.iconRes),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = achievement.title,
                style = TextStyle(fontSize = 18.sp)
            )
            Text(
                text = achievement.description,
                style = TextStyle(fontSize = 14.sp, color = Color.Gray)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AchievementActivityPreview() {
    TriviaGameTheme {
        val achievements = listOf(
            Achievement(
                title = "First Milestone",
                description = "You've completed your first milestone!",
                iconRes = R.drawable.brain
            ),
            Achievement(
                title = "Healthy Eater",
                description = "You've maintained a healthy diet for 30 days!",
                iconRes = R.drawable.brain
            ),
            Achievement(
                title = "Fitness Enthusiast",
                description = "You've completed 100 workouts!",
                iconRes = R.drawable.brain
            )
        )

        AchievementLayout(achievements = achievements)
    }
}



