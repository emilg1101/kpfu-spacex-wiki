package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class LandingLegs(
    @SerializedName("number") val number: Int,
    @SerializedName("material") val material: String
)
