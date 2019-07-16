package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Cargo(
    @SerializedName("solar_array") val solarArray: Int,
    @SerializedName("unpressurized_cargo") val unpressurizedCargo: Boolean
)
