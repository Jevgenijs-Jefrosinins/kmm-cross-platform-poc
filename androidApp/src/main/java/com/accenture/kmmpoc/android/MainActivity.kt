package com.accenture.kmmpoc.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.accenture.kmmpoc.Greeting
import com.accenture.kmmpoc.presentation.base.BaseDIActivity
import org.kodein.di.DI
import org.kodein.di.instance

class MainActivity : BaseDIActivity() {

    private val greeting by instance<Greeting>()

    override val initActivityDI: DI.Builder.() -> Unit
        get() = { /* import any module specific for that activity*/ }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView(greeting.greet())
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
