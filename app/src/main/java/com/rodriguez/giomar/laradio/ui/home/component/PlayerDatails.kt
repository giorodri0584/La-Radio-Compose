package com.rodriguez.giomar.laradio.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rodriguez.giomar.laradio.ui.theme.LightRed
import com.rodriguez.giomar.laradio.ui.theme.TextGray
import com.rodriguez.giomar.laradio.ui.theme.TextWhite

@Composable
fun PlayerDetails() {
    Column(
        modifier = Modifier
            .background(LightRed)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "100.3 FM",
            color = TextWhite,
            style = MaterialTheme.typography.h3
        )
        Text(
            text = "La Bakana - Snatiago",
            color = TextGray
        )
    }
}