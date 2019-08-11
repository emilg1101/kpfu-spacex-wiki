package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Mission(
    @SerializedName("mission_name") val missionName: String,
    @SerializedName("mission_id") val missionId: String,
    @SerializedName("manufacturers") val manufacturers: List<String>,
    @SerializedName("payload_ids") val payloadIds: List<String>,
    @SerializedName("wikipedia") val wikipedia: String?,
    @SerializedName("website") val website: String?,
    @SerializedName("twitter") val twitter: String?,
    @SerializedName("description") val description: String
)
