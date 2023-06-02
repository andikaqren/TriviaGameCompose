package com.example.triviagame

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviagame.data.QuestItem
import com.example.triviagame.ui.theme.TriviaGameTheme

class QuestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaGameTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Icon(
                                    painter = painterResource(id = R.drawable.target),
                                    contentDescription = "Energy Icon",
                                    tint = Color.Unspecified,
                                    modifier = Modifier.size(24.dp)
                                )
                                Text(
                                    text = "Daily Quest",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(id = R.color.blacky),
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
                    QuestMenu(

                    )
                }
            }
        }
    }
}

@Composable
fun QuestMenu() {
    val quests = listOf(
        QuestItem("Drink 8 glasses of water", false),
        QuestItem("Eat 5 servings of fruits and vegetables", false),
        QuestItem("Exercise for 30 minutes", false),
        QuestItem("Get 8 hours of sleep", false)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Finish all quests to earn 100 energy!",
            style = MaterialTheme.typography.h5,
            color = colorResource(id = R.color.blacky),
            fontFamily = FontFamily(Font(R.font.candy)),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        quests.forEachIndexed { index, quest ->
            Quest(quest = quest) {
                quests[index].completed = it
            }
        }
        Button(
            onClick = { claimRewards(quests) },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .align(Alignment.End)
        ) {
            Text(text = "Claim Rewards")
        }
    }
}

@Composable
fun Quest(quest: QuestItem, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = quest.completed,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.padding(end = 8.dp)
        )

        Text(
            text = quest.name,
            style = MaterialTheme.typography.subtitle1
        )
    }
}

fun claimRewards(quests: List<QuestItem>) {
    // Logic for claiming rewards based on completed quests
}
