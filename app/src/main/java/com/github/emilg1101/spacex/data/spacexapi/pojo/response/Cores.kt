package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Cores(
    @SerializedName("core_serial") val coreSerial: String?,
    @SerializedName("flight") val flight: Int?,
    @SerializedName("block") val block: Int?,
    @SerializedName("gridfins") val gridfins: Boolean?,
    @SerializedName("legs") val legs: Boolean?,
    @SerializedName("reused") val reused: Boolean,
    @SerializedName("land_success") val landSuccess: Boolean?,
    @SerializedName("landing_intent") val landingIntent: Boolean?,
    @SerializedName("landing_type") val landingType: String?,
    @SerializedName("landing_vehicle") val landingVehicle: String?
)
