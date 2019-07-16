package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Payloads (
	@SerializedName("option_1") val option1 : String,
	@SerializedName("composite_fairing") val compositeFairing : CompositeFairing
)
