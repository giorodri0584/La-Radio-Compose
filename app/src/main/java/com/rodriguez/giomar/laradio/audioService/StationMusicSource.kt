package com.rodriguez.giomar.laradio.audioService

import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.MediaMetadataCompat.*
import com.rodriguez.giomar.laradio.api.StationApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StationMusicSource {
    var stations = emptyList<MediaMetadataCompat>()

    suspend fun fetchMediaMetaData() = withContext(Dispatchers.IO) {
        state = State.STATE_INITIALIZING
        val allStations = StationApiService.fetchAllStations()
        stations = allStations.map { station ->
            MediaMetadataCompat.Builder()
                .putString(METADATA_KEY_ARTIST, station.name)
                .putString(METADATA_KEY_MEDIA_ID, station.objectId)
                .putString(METADATA_KEY_TITLE, station.frequency)
                .putString(METADATA_KEY_DISPLAY_TITLE, station.name)
                .putString(METADATA_KEY_DISPLAY_ICON_URI, station.logoUrl)
        }
    }

    private val onReadyListeners = mutableListOf<(Boolean) -> Unit>()
    private var state: State = State.STATE_CREATED
        set(value) {
            if(value == State.STATE_INITIALIZED || value == State.STATE_ERROR){
                synchronized(onReadyListeners){
                    field = value
                    onReadyListeners.forEach { listener ->
                        listener(state == State.STATE_INITIALIZED)
                    }
                }
            }else {
                field = value
            }
        }

    fun whenReady(
        action: (Boolean) -> Unit
    ): Boolean {
        if (state == State.STATE_CREATED || state == State.STATE_INITIALIZING) {
            onReadyListeners += action
            return false
        }else {
            action(state == State.STATE_INITIALIZED )
            return true
        }
    }
}

enum class State {
    STATE_CREATED,
    STATE_INITIALIZING,
    STATE_INITIALIZED,
    STATE_ERROR
}