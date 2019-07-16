package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class LaunchRocket(
    @SerializedName("rocket_id") val rocketId: String,
    @SerializedName("rocket_name") val rocketName: String,
    @SerializedName("rocket_type") val rocketType: String,
    @SerializedName("first_stage") val firstStage: FirstStage,
    @SerializedName("second_stage") val secondStage: SecondStage,
    @SerializedName("fairings") val fairings: Fairings
)
