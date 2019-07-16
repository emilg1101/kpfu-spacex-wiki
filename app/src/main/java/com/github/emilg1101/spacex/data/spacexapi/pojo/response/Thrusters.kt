package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Thrusters(
    @SerializedName("type") val type: String,
    @SerializedName("amount") val amount: Int,
    @SerializedName("pods") val pods: Int,
    @SerializedName("fuel_1") val fuel1: String,
    @SerializedName("fuel_2") val fuel2: String,
    @SerializedName("thrust") val thrust: Thrust
)
