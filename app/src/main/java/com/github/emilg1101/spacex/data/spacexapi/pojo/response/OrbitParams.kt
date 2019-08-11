package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class OrbitParams(
    @SerializedName("reference_system") val referenceSystem: String,
    @SerializedName("regime") val regime: String,
    @SerializedName("longitude") val longitude: String,
    @SerializedName("semi_major_axis_km") val semiMajorAxisKm: String,
    @SerializedName("eccentricity") val eccentricity: String,
    @SerializedName("periapsis_km") val periapsisKm: String,
    @SerializedName("apoapsis_km") val apoapsisKm: String,
    @SerializedName("inclination_deg") val inclinationDeg: String,
    @SerializedName("period_min") val periodMin: String,
    @SerializedName("lifespan_years") val lifespanYears: Double,
    @SerializedName("epoch") val epoch: String,
    @SerializedName("mean_motion") val meanMotion: String,
    @SerializedName("raan") val raan: String,
    @SerializedName("arg_of_pericenter") val argOfPericenter: String,
    @SerializedName("mean_anomaly") val meanAnomaly: String
)
