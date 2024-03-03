package com.example.jetbizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.ui.theme.JETBIZCARDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JETBIZCARDTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            shape = RoundedCornerShape(15.dp),
//            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                CreateImageProfile()

                Divider(
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    color = Color.Black
                )

                CreateInfo()

                Button(
                    onClick = {
                        buttonClickedState.value = !buttonClickedState.value
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Portfolio")
                }

                if (buttonClickedState.value) {
                    Content()
                }
            }
        }
    }
}

@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)
    ){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)
            ),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portfolio(data = listOf(
                "Project 1",
                "Project 2",
                "project 3",
                "project 4",
                "project 5"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){item ->
            Card(modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
                shape = RectangleShape
                ) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp)
                ) {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(modifier = Modifier.padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "Such a great project", style = MaterialTheme.typography.bodySmall)


                    }


                }
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Aman Jha",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(3.dp)
        )

        Text(
            text = "amanjha94211@gmail.com",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 10.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),

        ) {
        Image(
            painter = painterResource(id = R.drawable.profile_aman),
            contentDescription = "Profile image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JETBIZCARDTheme {
        CreateBizCard()
    }
}