package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("reddit") val reddit: String,
    @SerializedName("article") val article: String,
    @SerializedName("wikipedia") val wikipedia: String
)
