package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName
import java.util.*

data class Core(
    @SerializedName("core_serial") val coreSerial: String,
    @SerializedName("block") val block: String?,
    @SerializedName("status") val status: String,
    @SerializedName("original_launch") val originalLaunch: Date?,
    @SerializedName("original_launch_unix") val originalLaunchUnix: Int?,
    @SerializedName("missions") val missions: List<Missions>,
    @SerializedName("reuse_count") val reuseCount: Int,
    @SerializedName("rtls_attempts") val rtlsAttempts: Int,
    @SerializedName("rtls_landings") val rtlsLandings: Int,
    @SerializedName("asds_attempts") val asdsAttempts: Int,
    @SerializedName("asds_landings") val asdsLandings: Int,
    @SerializedName("water_landing") val waterLanding: Boolean,
    @SerializedName("details") val details: String?
)
