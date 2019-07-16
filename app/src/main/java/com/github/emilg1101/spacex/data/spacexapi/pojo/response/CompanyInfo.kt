package com.github.emilg1101.spacex.data.spacexapi.pojo.response

import com.google.gson.annotations.SerializedName

data class CompanyInfo(
    @SerializedName("name") val name: String,
    @SerializedName("founder") val founder: String,
    @SerializedName("founded") val founded: Int,
    @SerializedName("employees") val employees: Int,
    @SerializedName("vehicles") val vehicles: Int,
    @SerializedName("launch_sites") val launchSites: Int,
    @SerializedName("test_sites") val testSites: Int,
    @SerializedName("ceo") val ceo: String,
    @SerializedName("cto") val cto: String,
    @SerializedName("coo") val coo: String,
    @SerializedName("cto_propulsion") val ctoPropulsion: String,
    @SerializedName("valuation") val valuation: Int,
    @SerializedName("headquarters") val headquarters: Headquarters,
    @SerializedName("summary") val summary: String
)
