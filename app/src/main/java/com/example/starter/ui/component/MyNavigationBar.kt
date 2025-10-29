package com.example.starter.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Pets
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.starter.BirdNavKey
import com.example.starter.CatNavKey
import com.example.starter.DinosaurNavKey
import com.example.starter.PreviewSample

@Preview
@Composable
private fun Preview() = PreviewSample {
    Column {
        Box(
            Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        MyNavigationBar()
    }
}

@Composable
fun MyNavigationBar(backstack: NavBackStack? = null) {
    fun onClick(key: NavKey) {
        backstack?.clear()
        backstack?.add(key)
    }

    NavigationBar {
        NavigationBarItem(
            selected = backstack?.last() is DinosaurNavKey,
            onClick = { onClick(DinosaurNavKey()) },
            label = { Text("Dinos") },
            icon = {
                Icon(
                    Icons.Outlined.Category, ""
                )
            }
        )

        NavigationBarItem(
            selected = backstack?.last() is BirdNavKey,
            onClick = { onClick(BirdNavKey()) },
            label = { Text("Birds") },
            icon = {
                Icon(
                    Icons.Filled.Cloud, ""
                )
            }
        )

        NavigationBarItem(
            selected = backstack?.last() is CatNavKey,
            onClick = { onClick(CatNavKey()) },
            label = { Text("Cats") },
            icon = {
                Icon(
                    Icons.Outlined.Pets, ""
                )
            }
        )
    }
}