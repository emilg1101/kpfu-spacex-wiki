package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class PayloadVolume(
    @SerializedName("cubic_meters") val cubicMeters: Int,
    @SerializedName("cubic_feet") val cubicFeet: Int
)
