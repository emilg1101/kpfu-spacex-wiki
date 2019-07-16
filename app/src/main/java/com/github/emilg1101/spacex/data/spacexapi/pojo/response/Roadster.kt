package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Roadster(
    @SerializedName("name") val name: String,
    @SerializedName("launch_date_utc") val launchDateUtc: String,
    @SerializedName("launch_date_unix") val launchDateUnix: Int,
    @SerializedName("launch_mass_kg") val launchMassKg: Int,
    @SerializedName("launch_mass_lbs") val launchMassLbs: Int,
    @SerializedName("norad_id") val noradId: Int,
    @SerializedName("epoch_jd") val epochJd: Double,
    @SerializedName("orbit_type") val orbitType: String,
    @SerializedName("apoapsis_au") val apoapsisAu: Double,
    @SerializedName("periapsis_au") val periapsisAu: Double,
    @SerializedName("semi_major_axis_au") val semiMajorAxisAu: Double,
    @SerializedName("eccentricity") val eccentricity: Double,
    @SerializedName("inclination") val inclination: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("periapsis_arg") val periapsisArg: Double,
    @SerializedName("period_days") val periodDays: Double,
    @SerializedName("speed_kph") val speedKph: Double,
    @SerializedName("speed_mph") val speedMph: Double,
    @SerializedName("earth_distance_km") val earthDistanceKm: Double,
    @SerializedName("earth_distance_mi") val earthDistanceMi: Double,
    @SerializedName("mars_distance_km") val marsDistanceKm: Double,
    @SerializedName("mars_distance_mi") val marsDistanceMi: Double,
    @SerializedName("wikipedia") val wikipedia: String,
    @SerializedName("details") val details: String
)
