package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Capsule(
    @SerializedName("capsule_serial") val capsuleSerial: String,
    @SerializedName("capsule_id") val capsuleId: String,
    @SerializedName("status") val status: String,
    @SerializedName("original_launch") val originalLaunch: String,
    @SerializedName("original_launch_unix") val originalLaunchUnix: Int,
    @SerializedName("missions") val missions: List<Missions>,
    @SerializedName("landings") val landings: Int,
    @SerializedName("type") val type: String,
    @SerializedName("details") val details: String,
    @SerializedName("reuse_count") val reuseCount: Int
)
