package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Rocket(
    @SerializedName("id") val id: Int,
    @SerializedName("active") val active: Boolean,
    @SerializedName("stages") val stages: Int,
    @SerializedName("boosters") val boosters: Int,
    @SerializedName("cost_per_launch") val costPerLaunch: Long,
    @SerializedName("success_rate_pct") val successRatePct: Int,
    @SerializedName("first_flight") val firstFlight: String,
    @SerializedName("country") val country: String,
    @SerializedName("company") val company: String,
    @SerializedName("height") val height: Height,
    @SerializedName("diameter") val diameter: Diameter,
    @SerializedName("mass") val mass: Mass,
    @SerializedName("payload_weights") val payloadWeights: List<PayloadWeights>,
    @SerializedName("first_stage") val firstStage: RocketFirstStage,
    @SerializedName("second_stage") val secondStage: RocketSecondStage,
    @SerializedName("engines") val engines: Engines,
    @SerializedName("landing_legs") val landingLegs: LandingLegs,
    @SerializedName("wikipedia") val wikipedia: String,
    @SerializedName("description") val description: String,
    @SerializedName("rocket_id") val rocketId: String,
    @SerializedName("rocket_name") val rocketName: String,
    @SerializedName("rocket_type") val rocketType: String
)
