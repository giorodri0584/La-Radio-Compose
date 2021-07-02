package com.rodriguez.giomar.laradio.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodriguez.giomar.laradio.api.StationApiService
import com.rodriguez.giomar.laradio.model.StationState
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val TAG = "HomeViewModel"
    private val _stations: MutableLiveData<StationState> = MutableLiveData<StationState>()
    val stations: LiveData<StationState> = _stations
    //val stations: MutableState<StationState> = mutableStateOf(StationState.Loading)

    init {
        Log.d(TAG, "Initializing viewModel")
        fetchStations()
    }

    private fun fetchStations() {
        Log.d(TAG, "fetchStations()")
        //stations.value = StationState.Loading
        viewModelScope.launch {
            _stations.value =  StationApiService.fetchStations()
        }
    }
}