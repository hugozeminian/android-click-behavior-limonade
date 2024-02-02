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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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

//    val SizeFontSmall = 8.sp
    val SizeFontMedium = 16.sp
    val SizeFontLarge = 32.sp

//    val PaddingSmall = 8.dp
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
        var step by remember { mutableIntStateOf(1) }
        var squeezedLemonCount by remember { mutableIntStateOf(0) }
        Button(
            onClick = {
                if (squeezedLemonCount > 0) {
                    squeezedLemonCount--
                }

                if(squeezedLemonCount == 0){
                    step ++
                }

                if(step > 4){
                    step = 1
                }

                if(step == 2 && squeezedLemonCount == 0){
                    squeezedLemonCount = (3..6).random()
                }
            },
            shape = RoundedCornerShape(32.dp),
            colors = ButtonDefaults.buttonColors(AppTheme.BackgroudGreen),
            modifier = Modifier
                .size(256.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            LemonadeImageFlow(step)
        }
        LemonadeTextFlow(step, squeezedLemonCount)
    }
}

@Composable
fun LemonadeImageFlow(step: Int){
    when (step){
        1 -> {
            LemonadeImageSteps(lemonadeImageStep = R.drawable.lemon_tree)
        }

        2 -> {
            LemonadeImageSteps(lemonadeImageStep = R.drawable.lemon_squeeze)
        }

        3 -> {
            LemonadeImageSteps(lemonadeImageStep = R.drawable.lemon_drink)
        }

        4 -> {
            LemonadeImageSteps(lemonadeImageStep = R.drawable.lemon_restart)
        }
    }
}

@Composable
fun LemonadeTextFlow(step: Int, squeezedLemonCount: Int){
    when (step){
        1 -> {
            LemonadeTextSteps(textLemonadeStep = R.string.step_1, squeezedLemonCount)
        }

        2 -> {
            LemonadeTextSteps(textLemonadeStep = R.string.step_2, squeezedLemonCount)
        }

        3 -> {
            LemonadeTextSteps(textLemonadeStep = R.string.step_3, squeezedLemonCount)
        }

        4 -> {
            LemonadeTextSteps(textLemonadeStep = R.string.step_4, squeezedLemonCount)
        }
    }
}

@Composable
fun LemonadeImageSteps(lemonadeImageStep: Int){
    Image(painter = painterResource(id = lemonadeImageStep),
        contentDescription = null
    )
}

@Composable
fun LemonadeTextSteps(textLemonadeStep: Int, squeezedLemonCount: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = AppTheme.PaddingLarge)
            .wrapContentSize(Alignment.Center),
    ) {
        Text(
            text = stringResource(id = textLemonadeStep),
            fontSize = AppTheme.SizeFontMedium
        )

        if(squeezedLemonCount > 0){
        Text(
            text = "Lemons to squeeze: $squeezedLemonCount",
            fontSize = AppTheme.SizeFontMedium,
            modifier = Modifier.offset(y = 30.dp)
        )
        }
    }
}

