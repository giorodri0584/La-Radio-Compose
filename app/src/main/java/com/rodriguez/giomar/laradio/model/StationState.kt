package com.rodriguez.giomar.laradio.model

sealed class StationState {
    data class HasData(val stations: List<Station>): StationState()
    object Loading: StationState()
    data class Error(val error: String): StationState()
}
