package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class RocketFirstStage(
    @SerializedName("reusable") val reusable: Boolean,
    @SerializedName("engines") val engines: Int,
    @SerializedName("fuel_amount_tons") val fuelAmountTons: Double,
    @SerializedName("burn_time_sec") val burnTimeSec: Int,
    @SerializedName("thrust_sea_level") val thrustSeaLevel: ThrustSeaLevel,
    @SerializedName("thrust_vacuum") val thrustVacuum: ThrustVacuum
)
