package com.example.triviagame

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.triviagame.data.Question
import com.example.triviagame.ui.theme.TriviaGameTheme

class MainActivity : ComponentActivity() {
    private val startAchievementActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TriviaGameContent(this)
                }
            }
        }
    }
}


@Composable
fun TriviaGameContent(activity: Activity?) {
    // Sample question and options
    val questions = listOf(
        Question(
            question = "Which food is a good source of protein?",
            options = listOf("Chicken", "Ice cream", "French fries", "Soda"),
            correctAnswer = "Chicken"
        ),
        Question(
            question = "Which exercise is considered a cardiovascular activity?",
            options = listOf("Running", "Watching TV", "Sitting", "Sleeping"),
            correctAnswer = "Running"
        ),
        Question(
            question = "Which is a healthy breakfast option?",
            options = listOf("Oatmeal with fruits", "Donuts", "Chocolate cake", "Crispy bacon"),
            correctAnswer = "Oatmeal with fruits"
        )
    )
    // State for tracking selected option, current question, and score
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    val onNextQuestion = {
        // Perform logic to move to the next question
        if (currentQuestionIndex < questions.size - 1) {
            currentQuestionIndex++
            selectedOption = null
            if (score >= 10) {
                val intent = Intent(activity, AchievementActivity::class.java)
                activity?.startActivity(intent)
            }
        }
    }
    val onOptionSelected: (String) -> Unit = { option ->
        selectedOption = option
        val currentQuestion = questions[currentQuestionIndex]
        if (option == currentQuestion.correctAnswer) {
            score++
        }
    }
    val currentQuestion = questions[currentQuestionIndex]

    TriviaGameLayout(
        question = currentQuestion.question,
        options = currentQuestion.options,
        selectedOption = selectedOption,
        onOptionSelected = onOptionSelected,
        onNextQuestion = onNextQuestion,
        score = score,
        questionImage = painterResource(id = R.drawable.brain)
    )
}



@Composable
fun TriviaGameLayout(
    question: String,
    options: List<String>,
    selectedOption: String?,
    onOptionSelected: (String) -> Unit,
    onNextQuestion: () -> Unit,
    score: Int,
    questionImage: Painter
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Background Image
       /* Image(
            painter = painterResource(id = R.drawable.ui_background), // Replace with your background image resource
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )*/

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = questionImage,
                contentDescription = "Question Image",
                modifier = Modifier
                    .size(200.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .padding(bottom = 16.dp)
            )

            Text(
                text = question,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            options.forEach { option ->
                OptionButton(
                    text = option,
                    isSelected = option == selectedOption,
                    onClick = { onOptionSelected(option) }
                )
            }

            Button(
                onClick = onNextQuestion,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Next Question",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Text(
                text = "Score: $score",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun OptionButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val scale by animateFloatAsState(if (isSelected) 1.2f else 1f)

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .scale(scale),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isSelected) Color.Green else Color.White,
            contentColor = if (isSelected) Color.White else Color.Black
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TriviaGameTheme {
        TriviaGameContent(activity =null )
    }
}



