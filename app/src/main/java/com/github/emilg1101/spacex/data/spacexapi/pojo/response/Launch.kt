package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Launch(
    @SerializedName("flight_number") val flightNumber: Int,
    @SerializedName("mission_name") val missionName: String,
    @SerializedName("mission_id") val missionId: List<String>,
    @SerializedName("launch_year") val launchYear: Int,
    @SerializedName("launch_date_unix") val launchDateUnix: Int,
    @SerializedName("launch_date_utc") val launchDateUtc: String,
    @SerializedName("launch_date_local") val launchDateLocal: String,
    @SerializedName("is_tentative") val isTentative: Boolean,
    @SerializedName("tentative_max_precision") val tentativeMaxPrecision: String,
    @SerializedName("tbd") val tbd: Boolean,
    @SerializedName("launch_window") val launchWindow: String,
    @SerializedName("rocket") val rocket: Rocket,
    @SerializedName("ships") val ships: List<String>,
    @SerializedName("telemetry") val telemetry: Telemetry,
    @SerializedName("launch_site") val launchSite: LaunchSite,
    @SerializedName("launch_success") val launchSuccess: String,
    @SerializedName("links") val links: Links,
    @SerializedName("details") val details: String,
    @SerializedName("upcoming") val upcoming: Boolean,
    @SerializedName("static_fire_date_utc") val staticFireDateUtc: String,
    @SerializedName("static_fire_date_unix") val staticFireDateUnix: String,
    @SerializedName("timeline") val timeline: String
)
