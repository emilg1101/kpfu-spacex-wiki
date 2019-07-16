package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class LandingPad(
    @SerializedName("id") val id: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("status") val status: String,
    @SerializedName("location") val location: Location,
    @SerializedName("landing_type") val landingType: String,
    @SerializedName("attempted_landings") val attemptedLandings: Int,
    @SerializedName("successful_landings") val successfulLandings: Int,
    @SerializedName("wikipedia") val wikipedia: String,
    @SerializedName("details") val details: String
)
