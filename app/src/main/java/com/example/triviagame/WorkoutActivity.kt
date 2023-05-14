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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviagame.R
import com.example.triviagame.data.Workout
import com.example.triviagame.ui.theme.TriviaGameTheme

class WorkoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaGameTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Icon(
                                    painter = painterResource(id = R.drawable.workout),
                                    contentDescription = "Energy Icon",
                                    tint = Color.Unspecified,
                                    modifier = Modifier.size(24.dp)
                                )
                                Text(
                                    text = "Workout",
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
                    WorkoutScreen()
                }
            }
        }
    }
}


@Composable
fun WorkoutScreen() {
    val workouts = listOf(
        Workout("Push-ups", "Do 3 sets of 10 push-ups", R.drawable.push_up),
        Workout("Squats", "Do 3 sets of 15 squats", R.drawable.squad),
        Workout("Plank", "Hold a plank for 1 minute", R.drawable.yoga_pose),
        Workout("Jumping Jacks", "Do 3 sets of 20 jumping jacks", R.drawable.jumping_jack)
    )
    WorkoutList(workouts = workouts)
}

@Composable
fun WorkoutList(workouts: List<Workout>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(workouts) { workout ->
                WorkoutItem(workout = workout)
            }
        }

        Button(
            onClick = { /* Handle claim reward button click */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(text = "Claim Reward")
        }
    }
}

@Composable
fun WorkoutItem(workout: Workout) {
    Card(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = workout.name,
                style = MaterialTheme.typography.h6
            )
            Text(
                text = workout.description,
                style = MaterialTheme.typography.body2,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
            Icon(
                painter = painterResource(id = workout.iconRes),
                contentDescription = workout.name,
                tint = Color.Unspecified,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
