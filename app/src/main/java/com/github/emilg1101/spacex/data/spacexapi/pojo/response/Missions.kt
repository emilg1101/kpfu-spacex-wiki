package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Missions(
    @SerializedName("name") val name: String,
    @SerializedName("flight") val flight: Int
)

