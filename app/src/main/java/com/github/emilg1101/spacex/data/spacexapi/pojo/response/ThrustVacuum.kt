package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class ThrustVacuum(
    @SerializedName("kN") val kN: Int,
    @SerializedName("lbf") val lbf: Int
)
