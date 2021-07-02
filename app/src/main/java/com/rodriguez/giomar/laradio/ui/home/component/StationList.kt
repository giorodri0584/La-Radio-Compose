package com.rodriguez.giomar.laradio.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rodriguez.giomar.laradio.model.Station

@Composable
fun StationList(
    stations: List<Station>,
    city: String,
    onStationSelect: (Station) -> Unit
) {
    Column(
    ) {
        Text(
            text = city,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(stations.size) {
                StationCard(stations[it]) { station ->
                        onStationSelect(station)
                }
            }
        }
    }

}