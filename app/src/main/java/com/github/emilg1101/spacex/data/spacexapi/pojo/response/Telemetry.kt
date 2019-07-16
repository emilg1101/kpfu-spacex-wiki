package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Telemetry(
    @SerializedName("flight_club") val flightClub: String
)
