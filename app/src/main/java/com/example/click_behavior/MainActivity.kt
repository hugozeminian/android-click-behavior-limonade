package com.example.click_behavior

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.click_behavior.ui.theme.Click_behaviorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Click_behaviorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Click_behaviorTheme {
        MainApp()
    }
}

object AppTheme {
    val BackgroundYellow = Color(0xFFF8E44C)
    val BackgroudGreen = Color(0xFFC3ECD2)

    val SizeFontSmall = 8.sp
    val SizeFontMedium = 16.sp
    val SizeFontLarge = 32.sp

    val PaddingSmall = 8.dp
    val PaddingMedium = 16.dp
    val PaddingLarge = 32.dp
}

@Composable
fun MainApp(){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        TitleContainer()
        BodyContainer(
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Composable
fun TitleContainer(){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = AppTheme.BackgroundYellow)
            .padding(AppTheme.PaddingMedium),
    ) {
        Text(text = "Lemonade",
        fontSize = AppTheme.SizeFontLarge
        )
    }
}

@Composable
fun BodyContainer(modifier: Modifier){
    Column(
        modifier = modifier
    )
    {
        Button(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(32.dp),
            colors = ButtonDefaults.buttonColors(AppTheme.BackgroudGreen),
            modifier = Modifier.size(256.dp)
            ) {
            Image(painter = painterResource(id = R.drawable.lemon_drink),
                contentDescription = null
            )
        }

        Text(text = "phrase",
            modifier = Modifier
                .padding(top = AppTheme.PaddingLarge)
                .align(Alignment.CenterHorizontally),
            fontSize = AppTheme.SizeFontMedium
        )
    }
}

fun LemonadeFlow(){

}