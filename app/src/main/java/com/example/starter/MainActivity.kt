package com.example.starter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import com.example.starter.screen.DinosaurScreen
import com.example.starter.ui.component.MyNavDisplay
import com.example.starter.ui.component.MyNavigationBar
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Hides android action bar that is enabled by default
        actionBar?.hide()

        //Using utility to call setContent with theme and default background
        composeConstruct {
            ScreenContent()
        }
    }
}

//Navigation keys (Navigation 3)

@Serializable
class DinosaurNavKey() : NavKey

@Serializable
class BirdNavKey() : NavKey

@Serializable
class CatNavKey() : NavKey


@Preview
@Composable
private fun Preview() = PreviewSample {
    //Does not work at the time with NavDisplay
    //ScreenContent()

    //Thus in Preview NavDisplay is replaced with Box
    Column {
        Box(
            Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            DinosaurScreen()
        }
        MyNavigationBar()
    }
}

@Composable
fun ScreenContent() {
    //Maintains a record of destinations the user has visited
    val backstack = rememberNavBackStack(DinosaurNavKey())

    Column {
        MyNavDisplay(
            backstack = backstack,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        MyNavigationBar(backstack)
    }
}