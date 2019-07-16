package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class HeatShield (
	@SerializedName("material") val material : String,
	@SerializedName("size_meters") val sizeMeters : Double,
	@SerializedName("temp_degrees") val tempDegrees : Int,
	@SerializedName("dev_partner") val devPartner : String
)
