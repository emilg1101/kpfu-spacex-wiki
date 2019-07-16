package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Thrust(
    @SerializedName("kN") val kN: Double,
    @SerializedName("lbf") val lbf: Int
)
