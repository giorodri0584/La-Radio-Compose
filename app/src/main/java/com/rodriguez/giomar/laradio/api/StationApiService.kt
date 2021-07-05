package com.rodriguez.giomar.laradio.api

import android.util.Log
import com.rodriguez.giomar.laradio.model.Result
import com.rodriguez.giomar.laradio.model.Station
import com.rodriguez.giomar.laradio.model.StationState
import io.ktor.client.request.*

object StationApiService {
    suspend fun fetchStations(): StationState {
        val result: Result = MyKtorClient.client.get("${MyKtorClient.BASE_URL}/Stations")
        return StationState.HasData(result.results)
    }
    suspend fun fetchAllStations(): List<Station> {
        val result: Result = MyKtorClient.client.get("${MyKtorClient.BASE_URL}/Stations")
        return result.results
    }
}