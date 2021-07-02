package com.rodriguez.giomar.laradio.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.rodriguez.giomar.laradio.model.Station

@Composable
fun StationCard(
    station: Station,
    onStationSelect: (Station) -> Unit
) {
    Card(
        elevation = 5.dp,
        modifier = Modifier
            .size(150.dp,190.dp)
            .clickable {
                onStationSelect(station)
            }
    ) {
        Image(
            painter = rememberCoilPainter(
                request = station.logoUrl,
                fadeIn = true
            ),
            contentDescription = station.name,
            contentScale = ContentScale.FillBounds
        )
    }
}