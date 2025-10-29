package com.example.starter.ui.component

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.example.starter.BirdNavKey
import com.example.starter.CatNavKey
import com.example.starter.DinosaurNavKey
import com.example.starter.screen.BirdScreen
import com.example.starter.screen.CatScreen
import com.example.starter.screen.DinosaurScreen

@Composable
fun MyNavDisplay(backstack: List<NavKey>, modifier: Modifier = Modifier) {
    NavDisplay(
        backStack = backstack,
        entryDecorators = listOf(
            rememberSceneSetupNavEntryDecorator(),
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = { entryProvider(it) },
        modifier = modifier
    )
}

//Entry provider that tells NavDisplay what screen it should display
fun <T : Any> entryProvider(key: T): NavEntry<NavKey> = when (key) {
    is DinosaurNavKey -> NavEntry(key) { DinosaurScreen() }
    is BirdNavKey -> NavEntry(key) { BirdScreen() }
    is CatNavKey -> NavEntry(key) { CatScreen() }
    else -> throw Error()
}