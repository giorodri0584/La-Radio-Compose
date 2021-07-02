package com.rodriguez.giomar.laradio.model

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val results: List<Station>
)
