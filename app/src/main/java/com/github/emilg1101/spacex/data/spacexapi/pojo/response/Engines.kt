package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Engines(
    @SerializedName("number") val number: Int,
    @SerializedName("type") val type: String,
    @SerializedName("version") val version: String,
    @SerializedName("layout") val layout: String,
    @SerializedName("engine_loss_max") val engineLossMax: Int,
    @SerializedName("propellant_1") val propellant1: String,
    @SerializedName("propellant_2") val propellant2: String,
    @SerializedName("thrust_sea_level") val thrustSeaLevel: ThrustSeaLevel,
    @SerializedName("thrust_vacuum") val thrustVacuum: ThrustVacuum,
    @SerializedName("thrust_to_weight") val thrustToWeight: Double
)
