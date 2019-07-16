package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Trunk(
    @SerializedName("trunk_volume") val trunkVolume: TrunkVolume,
    @SerializedName("cargo") val cargo: Cargo
)
