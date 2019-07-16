package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Mass(
    @SerializedName("kg") val kg: Int,
    @SerializedName("lb") val lb: Int
)
