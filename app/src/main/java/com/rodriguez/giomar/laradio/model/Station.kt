package com.rodriguez.giomar.laradio.model

import kotlinx.serialization.Serializable

@Serializable
data class Station(
    var objectId: String,
    var name: String,
    var logoUrl: String,
    var url: String,
    var ciudad: String,
    var frequency: String,
    var isWorking: Boolean,
    var updatedAt: String,
    var createdAt: String
)
