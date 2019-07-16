package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class RocketSecondStage(
    @SerializedName("engines") val engines: Int,
    @SerializedName("fuel_amount_tons") val fuelAmountTons: Double,
    @SerializedName("burn_time_sec") val burnTimeSec: Int,
    @SerializedName("thrust") val thrust: Thrust,
    @SerializedName("payloads") val payloads: Payloads
)
