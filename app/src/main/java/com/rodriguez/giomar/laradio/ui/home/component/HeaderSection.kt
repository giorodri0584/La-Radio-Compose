package com.rodriguez.giomar.laradio.ui.home.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rodriguez.giomar.laradio.ui.theme.TextGray

@Composable
fun HeaderSection() {
    Text(
        text = "La Radio RD",
        style = MaterialTheme.typography.h5,
        color = TextGray,
        modifier = Modifier.padding(16.dp)
    )
}