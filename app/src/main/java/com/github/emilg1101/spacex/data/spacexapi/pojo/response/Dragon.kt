package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Dragon(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("active") val active: Boolean,
    @SerializedName("crew_capacity") val crewCapacity: Int,
    @SerializedName("sidewall_angle_deg") val sidewallAngleDeg: Int,
    @SerializedName("orbit_duration_yr") val orbitDurationYr: Int,
    @SerializedName("dry_mass_kg") val dryMassKg: Int,
    @SerializedName("dry_mass_lb") val dryMassLb: Int,
    @SerializedName("first_flight") val firstFlight: String,
    @SerializedName("heat_shield") val heatShield: HeatShield,
    @SerializedName("thrusters") val thrusters: List<Thrusters>,
    @SerializedName("launch_payload_mass") val launchPayloadMass: LaunchPayloadMass,
    @SerializedName("launch_payload_vol") val launchPayloadVol: LaunchPayloadVol,
    @SerializedName("return_payload_mass") val returnPayloadMass: ReturnPayloadMass,
    @SerializedName("return_payload_vol") val returnPayloadVol: ReturnPayloadVol,
    @SerializedName("pressurized_capsule") val pressurizedCapsule: PressurizedCapsule,
    @SerializedName("trunk") val trunk: Trunk,
    @SerializedName("height_w_trunk") val heightWithTrunk: HeightWithTrunk,
    @SerializedName("diameter") val diameter: Diameter,
    @SerializedName("wikipedia") val wikipedia: String,
    @SerializedName("description") val description: String
)
