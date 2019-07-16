package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Ship(
    @SerializedName("ship_id") val shipId: String,
    @SerializedName("ship_name") val shipName: String,
    @SerializedName("ship_model") val shipModel: String,
    @SerializedName("ship_type") val shipType: String,
    @SerializedName("roles") val roles: List<String>,
    @SerializedName("active") val active: Boolean,
    @SerializedName("imo") val imo: Int,
    @SerializedName("mmsi") val mmsi: Int,
    @SerializedName("abs") val abs: Int,
    @SerializedName("class") val shipClass: Int,
    @SerializedName("weight_lbs") val weightLbs: Int,
    @SerializedName("weight_kg") val weightKg: Int,
    @SerializedName("year_built") val yearBuilt: Int,
    @SerializedName("home_port") val homePort: String,
    @SerializedName("status") val status: String,
    @SerializedName("speed_kn") val speedKn: Int,
    @SerializedName("course_deg") val courseDeg: String,
    @SerializedName("position") val position: Position,
    @SerializedName("successful_landings") val successfulLandings: String,
    @SerializedName("attempted_landings") val attemptedLandings: String,
    @SerializedName("missions") val missions: List<Missions>,
    @SerializedName("url") val url: String,
    @SerializedName("image") val image: String
)
