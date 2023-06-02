package com.example.triviagame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.triviagame.R
import com.example.triviagame.ui.theme.TriviaGameTheme

data class LeaderboardItem(val name: String, val score: Int)

class LeaderboardActivity : ComponentActivity() {
    private val leaderboardData = listOf(
        LeaderboardItem("John Doe", 500),
        LeaderboardItem("Jane Smith", 400),
        LeaderboardItem("Adam Johnson", 300),
        LeaderboardItem("Emily Brown", 200),
        LeaderboardItem("Michael Wilson", 100)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaGameTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Icon(
                                    painter = painterResource(id = R.drawable.goals),
                                    contentDescription = "Energy Icon",
                                    tint = Color.Unspecified,
                                    modifier = Modifier.size(24.dp)
                                )
                                Text(
                                    text = "Leaderboards",
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
                    LeaderboardLayout(
                        leaderboardData
                    )
                }
            }
        }
    }
}

@Composable
fun LeaderboardLayout(leaderboard: List<LeaderboardItem>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Leaderboard",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(leaderboard) { item ->
                LeaderboardItem(item = item)
            }
        }
    }
}

@Composable
fun LeaderboardItem(item: LeaderboardItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.goals),
            contentDescription = "Score",
            tint = Color.Unspecified,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = item.name,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = item.score.toString(),
            style = MaterialTheme.typography.subtitle1,
            color = colorResource(id = R.color.blacky),
            fontFamily = FontFamily(Font(R.font.games)),
            modifier = Modifier.padding(end = 16.dp)
        )

        Icon(
            painter = painterResource(id = R.drawable.energy_drink),
            contentDescription = "Rank",
            tint = Color.Unspecified,
            modifier = Modifier.size(24.dp)
        )
    }
}
