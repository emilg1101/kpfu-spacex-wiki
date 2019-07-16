package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class PayloadWeights(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("kg") val kg: Int,
    @SerializedName("lb") val lb: Int
)
