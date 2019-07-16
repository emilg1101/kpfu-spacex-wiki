package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class PressurizedCapsule(
    @SerializedName("payload_volume") val payloadVolume: PayloadVolume
)
