package com.rodriguez.giomar.laradio.audioService

class StationMusicSource {
    private val onReadyListeners = mutableListOf<(Boolean) -> Unit>()
    private var states: State = State.STATE_CREATED
        set(value) {
            if(value == State.STATE_INITIALIZED || )
        }
}

enum class State {
    STATE_CREATED,
    STATE_INITIALIZING,
    STATE_INITIALIZED,
    STATE_ERROR
}