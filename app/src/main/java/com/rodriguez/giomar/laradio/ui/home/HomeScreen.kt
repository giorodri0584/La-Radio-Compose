package com.rodriguez.giomar.laradio.ui.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.rodriguez.giomar.laradio.model.Station
import com.rodriguez.giomar.laradio.model.StationState
import com.rodriguez.giomar.laradio.ui.home.component.PlayerDetails
import com.rodriguez.giomar.laradio.ui.home.component.StationMainList
import com.rodriguez.giomar.laradio.ui.theme.LightBackground
import com.rodriguez.giomar.laradio.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onStationSelect: (Station) -> Unit
) {
    val state by viewModel.stations.observeAsState(StationState.Loading)
    when(state) {
        is StationState.Loading -> {
            Text(
                text = "Loading ....."
            )
        }
        is StationState.HasData -> {
            state.let {
                if (it is StationState.HasData) {
                    RenderStations(stations = it.stations) { station ->
                        onStationSelect(station)
                    }
                }
            }
        }
        is StationState.Error -> {

        }
    }

}

@Composable
fun RenderStations(
    stations: List<Station>,
    onStationSelect: (Station) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBackground)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                PlayerDetails(

                )
            }
            Box(
                modifier = Modifier
                    .weight(2.5f)
                    .fillMaxSize()
            ) {
                StationMainList(
                    stations = stations
                ) { station ->
                    onStationSelect(station)
                }
            }

        }
    }
}