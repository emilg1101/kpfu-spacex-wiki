package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class LaunchPad(
    @SerializedName("id") val id: Int,
    @SerializedName("status") val status: String,
    @SerializedName("location") val location: Location,
    @SerializedName("vehicles_launched") val vehiclesLaunched: List<String>,
    @SerializedName("attempted_launches") val attemptedLaunches: Int,
    @SerializedName("successful_launches") val successfulLaunches: Int,
    @SerializedName("wikipedia") val wikipedia: String,
    @SerializedName("details") val details: String,
    @SerializedName("site_id") val site_id: String,
    @SerializedName("site_name_long") val siteNameLong: String
)
