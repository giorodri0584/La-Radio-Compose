package com.rodriguez.giomar.laradio.ui.home.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.rodriguez.giomar.laradio.model.Station

@Composable
fun StationMainList(
    stations: List<Station>,
    onStationSelect: (Station) -> Unit
) {
    val cities = remember {
        stations.distinctBy { it.ciudad }
    }
   LazyColumn(
       modifier = Modifier
           .fillMaxWidth()
    ) {
        items(cities.size) {
            StationList(
                stations = stations.filter { station ->
                    station.ciudad == cities[it].ciudad
                },
                city = cities[it].ciudad
            ) { station ->
                onStationSelect(station)
            }
        }
    }
}