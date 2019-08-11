package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName
import java.util.*

data class HistoricalEvent(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("event_date_utc") val eventDateUtc: Date,
    @SerializedName("event_date_unix") val eventDateUnix: Int,
    @SerializedName("flight_number") val flightNumber: Int?,
    @SerializedName("details") val details: String,
    @SerializedName("links") val links: Links
)
