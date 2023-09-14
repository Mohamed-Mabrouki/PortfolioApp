package com.example.jetbizzcard

import android.os.Bundle
import android.provider.MediaStore.Images.ImageColumns
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbizzcard.ui.theme.JetBizzCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizzCardTheme { // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizzCard()
                }
            }
        }
    }
}
@Composable
fun CreateBizzCard() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateImageProfile()
                Divider(
                    thickness = 1.dp, color = Color.LightGray
                )
                CreateInfo()
                Button(
                    onClick = {
                        buttonClickedState.value = !buttonClickedState.value
                        Log.d("sqdqsdqsd", buttonClickedState.value.toString())
                    }, shape = RoundedCornerShape(5.dp), colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF6B04CF)
                    )
                ) {
                    Text(text = "Portfolio")
                }
                if (buttonClickedState.value) {
                    Content()
                } else {
                    Box {}
                }
            }
        }
    }

}
@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(15.dp)) {
        Text(
            text = "Mohamed Mab",
            style = MaterialTheme.typography.headlineLarge,
            color = Color(0xFF6B04CF)
        )
        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(3.dp),
            fontStyle = FontStyle.Italic,
            fontSize = 18.sp
        )
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(3.dp),
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp
        )
    }
}
//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBizzCardTheme {
        CreateBizzCard()
    }
}
@Composable
fun CreateImageProfile(modifier : Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 5.dp,
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}
@Preview(showBackground = true)
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxSize(),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            border = BorderStroke(2.dp, Color.LightGray)
        ) {
            Portfolio(
                data = listOf(
                    "project 1",
                    "project 2",
                    "project 4",
                    "project 5",
                    "project 6",
                    "project 7",
                    "project 8",
                    "project 9",
                    "project 10",
                    "project 11",
                    "project 12",
                    "project 13",
                )
            )
        }
    }
}
@Composable
fun Portfolio(data : List<String>) {
    LazyColumn(modifier = Modifier.background(Color.White)) {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth()
                , shape = RectangleShape
            ) {
                Row(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(corner = CornerSize(50.dp))
                        )
                        .clickable {  }
                        .padding(
                            16.dp
                        )
                ) {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column (modifier = Modifier
                        .padding(4.dp)
                        .align(
                            alignment = Alignment.CenterVertically
                        )){
                        Text(item, fontWeight = FontWeight.Bold)
                        Text(text = "A great project")
                    }
                }
            }
        }
    }
} //@Composable //fun Portfolio(data : List<String>) { //    LazyColumn(modifier = Modifier.background(Color.White)) {
//        items(data) { item ->
//            Box(
//                modifier = Modifier
//                    .padding(8.dp, 5.dp)
//                    .clip(RoundedCornerShape(corner = CornerSize(5.dp)))
//                    .height(120.dp)
//                    .fillMaxWidth()
//                    .background(Color.White)
//                    .border(BorderStroke(2.dp, Color.LightGray)),
//            ) {
//                CreateImageProfile(
//                    modifier = Modifier
//                        .height(70.dp)
//                        .width(70.dp)
//                        .offset(22.dp, 20.dp)
//                )
//
//                Text(
//                    text = item,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .offset(92.dp, 35.dp),
//                    fontSize = 15.sp,
//                    fontWeight = FontWeight(620),
//                    fontStyle = FontStyle.Italic
//                )
//            }
//        }
//    }
//
//}
