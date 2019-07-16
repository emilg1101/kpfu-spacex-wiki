package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class CompositeFairing(
    @SerializedName("height") val height: Height,
    @SerializedName("diameter") val diameter: Diameter
)
