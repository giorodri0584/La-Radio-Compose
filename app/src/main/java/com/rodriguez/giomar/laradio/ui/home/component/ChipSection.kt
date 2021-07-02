package com.rodriguez.giomar.laradio.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rodriguez.giomar.laradio.ui.theme.TextGray
import com.rodriguez.giomar.laradio.ui.theme.TextRed

@Composable
fun ChipSection() {
    val categories by remember {
        mutableStateOf(listOf("Favoritos", "Todos", "Santiago", "Santo Domingo"))
    }
    var selectedCategory by remember {
        mutableStateOf(0)
    }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        items(categories.size) {
            Column(
                modifier = Modifier
                    .clickable {
                        selectedCategory = it
                    }
            ) {
                Text(
                    text = categories[it],
                    color = if (selectedCategory == it) TextRed else TextGray,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(16.dp)
                )
//                Text(
//                    text = ".",
//                    style = MaterialTheme.typography.h1,
//                    color = TextRed
//                )
            }

        }
    }
}