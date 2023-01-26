package com.orlandev.recompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.orlandev.recompose.ui.theme.RecomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {

        val (box1, box2, box3) = createRefs()

        Box(modifier = Modifier
            .size(50.dp)
            .background(Red)
            .constrainAs(ref = box1) {}
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Green)
                .constrainAs(ref = box2) {
                    top.linkTo(box1.bottom)
                    start.linkTo(box1.end)
                }
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Blue)
                .constrainAs(ref = box3) {

                    top.linkTo(box2.top)
                    start.linkTo(box2.end,20.dp)

                }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecomposeTheme {
        Greeting("Android")
    }
}