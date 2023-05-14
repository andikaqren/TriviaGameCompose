package com.example.triviagame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviagame.data.StoreItem
import com.example.triviagame.ui.theme.TriviaGameTheme


class StoreActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaGameTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Store",
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
                    StoreLayout()
                }
            }
        }
    }
}


@Composable
fun StoreLayout() {
    val coinCount = remember { mutableStateOf(100) }

    val items = listOf(
        StoreItem(
            name = "Vitamin",
            icon = painterResource(id = R.drawable.supplement),
            price = "10"
        ),
        StoreItem(
            name = "Voucher Free Shipping",
            icon = painterResource(id = R.drawable.free_shipping),
            price = "20"
        ),
        StoreItem(
            name = "Voucher Discount Medicine",
            icon = painterResource(id = R.drawable.coupon),
            price = "20"
        ),
        StoreItem(
            name = "Yoga Mat",
            icon = painterResource(id = R.drawable.yoga_mat),
            price = "20"
        ),
        StoreItem(
            name = "Healthy Snack",
            icon = painterResource(id = R.drawable.granola),
            price = "20"
        ),
        StoreItem(
            name = "Free Consultation Halodoc",
            icon = painterResource(id = R.drawable.consulting),
            price = "20"
        ),
        StoreItem(
            name = "Healthy Cookbook",
            icon = painterResource(id = R.drawable.recipe_book),
            price = "20"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.energy_drink),
                    contentDescription = "Coin",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${coinCount.value}",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.clickable { /* Handle coin count click */ }
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.store),
            contentDescription = "Coins",
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 16.dp)
        )

        Text(
            text = "Welcome to the Store",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        items.forEach { item ->
            StoreItemRow(item)
        }
    }
}


@Composable
fun StoreItemRow(item: StoreItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = item.icon,
            contentDescription = item.name,
            tint = Color.Unspecified,
            modifier = Modifier.size(32.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = item.name,
                style = MaterialTheme.typography.subtitle1
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                val priceText =item.price
                Text(
                    text = priceText,
                    style = MaterialTheme.typography.body2,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 4.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.energy_drink),
                    contentDescription = "Coin Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(16.dp)
                )

            }
        }


        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { /* Handle buy button click */ },
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Text(text = "Buy")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStoreLayout() {
    TriviaGameTheme {
        StoreLayout()
    }
}