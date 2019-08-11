package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Payload(
    @SerializedName("payload_id") val payloadId: String,
    @SerializedName("norad_id") val noradId: List<String>,
    @SerializedName("reused") val reused: Boolean,
    @SerializedName("customers") val customers: List<String>,
    @SerializedName("nationality") val nationality: String?,
    @SerializedName("manufacturer") val manufacturer: String?,
    @SerializedName("payload_type") val payloadType: String,
    @SerializedName("payload_mass_kg") val payloadMassKg: Double?,
    @SerializedName("payload_mass_lbs") val payloadMassLbs: Double?,
    @SerializedName("orbit") val orbit: String,
    @SerializedName("orbit_params") val orbitParams: OrbitParams
)
