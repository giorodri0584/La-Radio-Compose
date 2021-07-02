package com.rodriguez.giomar.laradio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.rodriguez.giomar.laradio.model.Station
import com.rodriguez.giomar.laradio.ui.home.HomeScreen
import com.rodriguez.giomar.laradio.ui.theme.LaRadioTheme

class MainActivity : ComponentActivity() {
    lateinit var player: SimpleExoPlayer
    lateinit var mediaItem: MediaItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        player = SimpleExoPlayer.Builder(applicationContext).build()




        setContent {
            LaRadioTheme {
               HomeScreen() { station ->
                   playStation(station = station )
               }
            }
        }
    }

    private fun playStation(
        station: Station
    ) {
        mediaItem = MediaItem.fromUri(station.url)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }
}