package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Fairings(
    @SerializedName("reused") val reused: Boolean,
    @SerializedName("recovery_attempt") val recoveryAttempt: Boolean,
    @SerializedName("recovered") val recovered: Boolean,
    @SerializedName("ship") val ship: String
)
