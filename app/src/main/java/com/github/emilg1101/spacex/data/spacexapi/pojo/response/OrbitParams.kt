package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName
import java.util.*

data class OrbitParams(
    @SerializedName("reference_system") val referenceSystem: String?,
    @SerializedName("regime") val regime: String?,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("semi_major_axis_km") val semiMajorAxisKm: Double?,
    @SerializedName("eccentricity") val eccentricity: Double?,
    @SerializedName("periapsis_km") val periapsisKm: Double?,
    @SerializedName("apoapsis_km") val apoapsisKm: Double?,
    @SerializedName("inclination_deg") val inclinationDeg: Double?,
    @SerializedName("period_min") val periodMin: Double?,
    @SerializedName("lifespan_years") val lifespanYears: Double?,
    @SerializedName("epoch") val epoch: Date?,
    @SerializedName("mean_motion") val meanMotion: Double?,
    @SerializedName("raan") val raan: Double?,
    @SerializedName("arg_of_pericenter") val argOfPericenter: String,
    @SerializedName("mean_anomaly") val meanAnomaly: String
)
