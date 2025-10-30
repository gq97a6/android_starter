package com.example.starter.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.starter.PreviewSample
import com.example.starter.cs
import com.example.starter.ui.component.MyTopAppBar
import com.example.starter.viewmodel.BirdViewModel

@Preview
@Composable
private fun Preview() = PreviewSample { BirdScreen() }

@Composable
fun BirdScreen(vm: BirdViewModel = viewModel()) {
    val isLoading by vm.isLoading.collectAsStateWithLifecycle()
    val birds by vm.birds.collectAsStateWithLifecycle()

    Column(Modifier.fillMaxSize()) {
        MyTopAppBar("Birds", "Checkout these cool birds!")
        Box(Modifier.fillMaxSize()) {
            if (!isLoading) LazyColumn(Modifier.align(Alignment.Center)) {
                birds.forEach {
                    item(it.id) {
                        Text(
                            text = "Hi, my name is ${it.name}!",
                            color = cs.primary
                        )
                    }
                }
            }

            if (isLoading) LoadingIndicator(Modifier.align(Alignment.Center))

            //By pattern (MVVM) views do not modify state of the app.
            //Views also do not contain business logic thus we use callback defined in viewmodel.
            Button(
                onClick = vm::selectRandomBird,
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .align(Alignment.BottomCenter)
            ) { Text("Select Random") }
        }
    }
}