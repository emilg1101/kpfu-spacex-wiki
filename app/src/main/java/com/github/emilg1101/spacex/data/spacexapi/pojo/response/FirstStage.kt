package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class FirstStage(
    @SerializedName("cores") val cores: List<Cores>
)
