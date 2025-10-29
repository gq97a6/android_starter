package com.example.starter.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.starter.PreviewSample
import com.example.starter.cs

@Preview
@Composable
private fun Preview() = PreviewSample {
    Column {
        MyTopAppBar()
        Box(
            Modifier
                .weight(1f)
                .fillMaxWidth()
        )
    }
}

@Composable
fun MyTopAppBar(title: String = "Title", subtitle: String = "Subtitle") {
    var isMenuExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(
                title,
                fontWeight = FontWeight.Black,
                color = cs.tertiary
            )
        },
        subtitle = {
            Text(
                subtitle,
                fontWeight = FontWeight.Bold,
                color = cs.primary
            )
        },
        actions = {
            // Placeholder list of 100 strings for demonstration
            val menuItemData = List(5) { "Option ${it + 1}" }

            Box(Modifier) {
                IconButton(onClick = { isMenuExpanded = !isMenuExpanded }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "More options",
                        tint = cs.primary
                    )
                }
                DropdownMenu(
                    expanded = isMenuExpanded,
                    onDismissRequest = { isMenuExpanded = false },
                    offset = DpOffset(x = (-20).dp, y = 0.dp)
                ) {
                    menuItemData.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option) },
                            onClick = { /* Do something... */ }
                        )
                    }
                }
            }
        },
        navigationIcon = {
            Icon(
                Icons.Filled.ArrowBackIosNew,
                contentDescription = "",
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
    )
}