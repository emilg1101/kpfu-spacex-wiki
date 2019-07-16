package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Height(
    @SerializedName("meters") val meters: Double,
    @SerializedName("feet") val feet: Double
)
